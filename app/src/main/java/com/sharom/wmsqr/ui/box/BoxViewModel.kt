package com.sharom.wmsqr.ui.box

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharom.wmsqr.data.auth.api.ApiClient
import com.sharom.wmsqr.domain.box.model.BoxGroupDto
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BoxViewModel: ViewModel() {

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    var items by mutableStateOf<List<BoxGroupDto>>(emptyList())
        private set

    init {
        loadBoxes()
    }

    fun loadBoxes() {
        viewModelScope.launch {
            isLoading = true
            error = null

            try {
                val response = ApiClient.boxApi.getBoxGroups()
                items = response.items
            } catch (e: Exception) {
                error = e.message ?: "Unknown error"
            } finally {
                isLoading = false
            }
        }
    }
}