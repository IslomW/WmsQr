package com.sharom.wmsqr.domain.auth.model

data class LoginRequest(
    val username: String,
    val password: String
)