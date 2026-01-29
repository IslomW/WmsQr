package com.sharom.wmsqr.domain.box.model

data class ConfirmRequest(
    val shipmentId: String,
    val scannedBoxes: List<String>
)
