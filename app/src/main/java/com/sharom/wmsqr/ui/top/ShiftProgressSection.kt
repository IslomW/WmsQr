package com.sharom.wmsqr.ui.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun ShiftProgressSection() {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Picks Completed", fontWeight = FontWeight.SemiBold)
                Text("45/100", fontWeight = FontWeight.Bold)
            }

            Spacer(Modifier.height(8.dp))

            LinearProgressIndicator(progress = 0.45f)

            Spacer(Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                InfoColumn("Avg Time", "2.4 min")
                InfoColumn("Efficiency", "98.2%", Color(0xFF0BDA5B))
            }
        }
    }
}

@Composable
fun InfoColumn(label: String, value: String, color: Color = Color.Unspecified) {
    Column {
        Text(label.uppercase(), color = Color.Gray, fontSize = 10.sp)
        Text(value, fontWeight = FontWeight.Bold, color = color)
    }
}