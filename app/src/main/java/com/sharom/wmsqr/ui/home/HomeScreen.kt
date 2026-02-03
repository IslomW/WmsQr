package com.sharom.wmsqr.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sharom.wmsqr.ui.top.GreetingSection
import com.sharom.wmsqr.ui.top.QuickActionsSection
import com.sharom.wmsqr.ui.top.ShiftProgressSection
import com.sharom.wmsqr.ui.top.StatsSection
import com.sharom.wmsqr.ui.top.TopAppBar

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        TopAppBar()

        LazyColumn {
            item { GreetingSection() }
            item { StatsSection() }
            item { QuickActionsSection() }
            item { ShiftProgressSection() }
        }
    }
}