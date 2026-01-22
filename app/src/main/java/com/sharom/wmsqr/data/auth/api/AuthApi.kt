package com.sharom.wmsqr.data.auth.api

import com.sharom.wmsqr.domain.auth.model.AuthResponse
import com.sharom.wmsqr.domain.auth.model.LoginRequest
import com.sharom.wmsqr.domain.auth.model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("api/v1/auth/register")
    suspend fun register(@Body request: RegisterRequest)
}