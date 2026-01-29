package com.sharom.wmsqr.data.auth.api

import com.sharom.wmsqr.domain.box.model.UserDTO
import retrofit2.http.GET

interface UserApi {
    @GET("/api/v1/users/whoami")
    suspend fun getUser(): UserDTO
}