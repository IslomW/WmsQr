package com.sharom.wmsqr.ui.truck

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun StatusChips() {
    val statuses = listOf("All", "In Transit", "Processing", "Delivered")

    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(statuses) { status ->
            FilterChip(
                selected = status == "All",
                onClick = {},
                label = { Text(status) }
            )
        }
    }
}