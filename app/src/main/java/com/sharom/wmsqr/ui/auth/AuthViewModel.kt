package com.sharom.wmsqr.ui.auth

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharom.wmsqr.data.auth.SessionManager
import com.sharom.wmsqr.data.auth.TokenManager
import com.sharom.wmsqr.data.auth.api.ApiClient
import com.sharom.wmsqr.domain.auth.model.LoginRequest
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var isLoading by mutableStateOf(false)
    var error by mutableStateOf<String?>(null)

    fun login(
        context: Context,
        onSuccess: () -> Unit
    ) {
        viewModelScope.launch {
            try {
                isLoading = true
                val response = ApiClient.authApi.login(
                    LoginRequest(username , password)
                )
                SessionManager.accessToken = response.accessToken
                TokenManager.saveToken(context, response.accessToken)
                Log.w("Token",response.accessToken)

                // Переход на Main
                onSuccess()

            } catch (e: Exception) {
                error = "Login failed"
            } finally {
                isLoading = false
            }
        }
    }
}