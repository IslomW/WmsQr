package com.sharom.wmsqr.ui.truck

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sharom.wmsqr.ui.top.TopAppBar

@Composable
fun InventoryTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Track Inventory",
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Notifications, contentDescription = null)
            }
        }
    )
}