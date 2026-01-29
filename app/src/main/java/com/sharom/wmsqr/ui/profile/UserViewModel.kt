package com.sharom.wmsqr.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharom.wmsqr.data.auth.api.ApiClient
import com.sharom.wmsqr.domain.box.model.UserDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val user = MutableStateFlow<UserDTO?>(null)

    fun loadUser() {
        viewModelScope.launch {
            user.value = ApiClient.userApi.getUser()
        }
    }
}