package com.sharom.wmsqr.data.auth

object SessionManager {
    @Volatile
    var accessToken: String? = null
}