package com.sharom.wmsqr.ui.top

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
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
fun QuickActionsSection() {
    Column(Modifier.padding(16.dp)) {
        Text(
            "Quick Actions",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.height(220.dp)
        ) {
            item { ActionCard("Receive", "Inbound dock scanning", painterResource(R.drawable.resource_package) ) }
            item { ActionCard("Put Away", "Shelving & stocking", painterResource(R.drawable.inventory_2_24dp)) }
            item { ActionCard("Pick", "Fulfillment picking", painterResource(R.drawable.pick_24dp)) }
            item { ActionCard("Pack", "Shipping preparation", painterResource(R.drawable.pack_24dp)) }
        }
    }

}

@Composable
fun ActionCard(title: String, desc: String, icon: Painter) {
    Card {
        Column(Modifier.padding(16.dp)) {
            Icon(icon, contentDescription = title)
            Spacer(Modifier.height(8.dp))
            Text(title, fontWeight = FontWeight.Bold)
            Text(desc, color = Color.Gray, fontSize = 12.sp)
        }
    }
}