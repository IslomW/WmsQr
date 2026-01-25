package com.sharom.wmsqr.domain.auth.model

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
)