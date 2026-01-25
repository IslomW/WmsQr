package com.sharom.wmsqr.domain.box.model

data class BoxGroupDto(
    val id: String,
    val description: String,
    val boxType: String,
    val quantity: Int,
    val weight: Double,
    val length: Double,
    val width: Double,
    val height: Double
)
