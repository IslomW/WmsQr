package com.sharom.wmsqr.ui.auth

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharom.wmsqr.data.auth.api.ApiClient
import com.sharom.wmsqr.domain.auth.model.RegisterRequest
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    var username by mutableStateOf("")
    var name by mutableStateOf("")
    var phoneNumber by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)


    fun register(
        context: Context,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {

            try {
                isLoading = true
                ApiClient.authApi.register(
                    RegisterRequest(
                        username,
                        name,
                        phoneNumber,
                        email,
                        password
                    )
                )

                onSuccess()
            } catch (e: Exception) {
                error = "Registration failed"
            } finally {
                isLoading = false
            }

        }

    }
}