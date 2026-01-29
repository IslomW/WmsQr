package com.sharom.wmsqr.ui.scan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sharom.wmsqr.domain.box.model.ScanRepository

class ScanVmFactory(
    private val repo: ScanRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ScanViewModel(repo) as T
    }
}