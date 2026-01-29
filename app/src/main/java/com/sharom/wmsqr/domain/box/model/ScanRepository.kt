package com.sharom.wmsqr.domain.box.model

import com.sharom.wmsqr.data.auth.api.BoxApi

class ScanRepository(
    private val api: BoxApi
) {

    suspend fun loadBoxes(boxGroupId: String): List<BoxDTO> {
        return api.getBoxByGroupId(boxGroupId)
    }

    suspend fun confirm(
        shipmentId: String,
        boxes: List<String>
    ) {
        api.confirmScan(
            ConfirmRequest(
                shipmentId,
                boxes
            )
        )
    }
}