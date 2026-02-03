package com.sharom.wmsqr.ui.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LowStockCard(){

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Low Stock Alerts", color = Color.Gray)
            Text(
                "5 Items",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Spacer(Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = 0.15f,
                color = Color.Red
            )

            Text(
                "Immediate action required in Aisle 4",
                color = Color.Gray,
                fontSize = 10.sp,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }

}