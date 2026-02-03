package com.sharom.wmsqr.ui.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sharom.wmsqr.R

@Composable
fun StatsSection() {

    Row(
        Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatCard("Active Orders", "124", painterResource(R.drawable.list), Color(0xFF0BDA5B))
        StatCard("Shipments", "18", painterResource(R.drawable.local_shipping_24dp), Color(0xFFFA6238))
    }

    Spacer(Modifier.height(12.dp))

    LowStockCard()
}

@Composable
fun StatCard(
    title: String,
    value: String,
    icon: Painter,
    trendColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(title, color = Color.Gray, style = MaterialTheme.typography.bodySmall)
                Icon(icon, contentDescription = title)
            }
            Text(value, fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Text("+12%", color = trendColor, fontWeight = FontWeight.Bold, fontSize = 12.sp)
        }
    }
}