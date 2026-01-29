package com.sharom.wmsqr.ui.scan

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharom.wmsqr.domain.box.model.ScanRepository
import com.sharom.wmsqr.ui.ScanBox
import com.sharom.wmsqr.ui.ScanResult
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class ScanViewModel(
    private val repo: ScanRepository
) : ViewModel() {

    var boxes = mutableStateListOf<ScanBox>()
        private set

    var loading by mutableStateOf(false)
    var scannedCount by mutableStateOf(0)

    lateinit var shipmentId: String

    fun load(shipmentId: String) {
        this.shipmentId = shipmentId

        viewModelScope.launch {
            loading = true

            val list = repo.loadBoxes(shipmentId)

            boxes.clear()
            boxes.addAll(list.map { ScanBox(it.boxId) })

            loading = false
        }
    }

    fun onScan(boxId: String): ScanResult {
        val box = boxes.find { it.boxId == boxId }
            ?: return ScanResult.NOT_FOUND

        if (box.scanned) {
            return ScanResult.ALREADY_SCANNED
        }

        box.scanned = true
        scannedCount++

        return ScanResult.OK
    }

    fun confirmAll(onDone: () -> Unit) {
        viewModelScope.launch {
            val scanned = boxes
                .filter { it.scanned }
                .map { it.boxId }

            repo.confirm(shipmentId, scanned)
            onDone()
        }
    }


}