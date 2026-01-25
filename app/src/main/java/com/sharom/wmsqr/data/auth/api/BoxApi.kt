package com.sharom.wmsqr.data.auth.api

import com.sharom.wmsqr.domain.box.model.BoxGroupDto
import com.sharom.wmsqr.domain.box.model.PageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BoxApi {

    @GET("/api/v1/box-groups")
    suspend fun getBoxGroups(
        @Query("page") page: Int = 0
    ): PageResponse<BoxGroupDto>
}