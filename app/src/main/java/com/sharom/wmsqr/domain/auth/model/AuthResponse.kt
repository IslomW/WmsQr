package com.sharom.wmsqr.domain.auth.model

data class AuthResponse(
    val token: String,
    val refreshToken: String
)