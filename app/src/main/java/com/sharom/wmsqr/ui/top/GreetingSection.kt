package com.sharom.wmsqr.ui.top

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun GreetingSection() {

    Column(Modifier.padding(16.dp)) {
        Text(
            "Good Morning, Marcus",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Here is what's happening in your zone today.",
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}