package com.sharom.wmsqr.domain.auth.model

data class RegisterRequest(
    val username: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val password: String
)