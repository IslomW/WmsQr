package com.sharom.wmsqr.ui.truck

data class Shipment(      val status: ShipmentStatus,
                          val orderId: String,
                          val progress: Float,
                          val location: String,
                          val time: String
)
