package com.sharom.wmsqr.domain.box.model

data class PageResponse<T>(
    val pageNumber: Int,
    val previous: Boolean,
    val next: Boolean,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int,
    val items: List<T>
)
