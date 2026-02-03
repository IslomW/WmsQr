package com.sharom.wmsqr.ui.truck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharom.wmsqr.R

@Composable
fun ShipmentCard(shipment: Shipment) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    Text(
                        text = shipment.status.name.replace("_", " "),
                        color = shipment.status.color(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Order #${shipment.orderId}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Icon(
                    painter = painterResource(shipment.status.iconRes()),
                    contentDescription = null,
                    tint = shipment.status.color(),
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(Modifier.height(12.dp))

            LinearProgressIndicator(
                progress = shipment.progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                color = shipment.status.color(),
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )

            Spacer(Modifier.height(12.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("📍 ${shipment.location}", fontSize = 12.sp)
                    Text("⏱ ${shipment.time}", fontSize = 12.sp)
                }

                Button(onClick = {}) {
                    Text("Details")
                }
            }
        }
    }
}


fun ShipmentStatus.color(): Color = when (this) {
    ShipmentStatus.IN_TRANSIT -> Color(0xFF137FEC)
    ShipmentStatus.PROCESSING -> Color(0xFFF59E0B)
    ShipmentStatus.DELIVERED  -> Color(0xFF10B981)
}

fun ShipmentStatus.iconRes(): Int = when (this) {
    ShipmentStatus.IN_TRANSIT -> R.drawable.ic_in_transit
    ShipmentStatus.PROCESSING -> R.drawable.ic_processing
    ShipmentStatus.DELIVERED  -> R.drawable.ic_delivered
}
