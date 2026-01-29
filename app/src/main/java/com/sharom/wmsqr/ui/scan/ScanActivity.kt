package com.sharom.wmsqr.ui.scan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sharom.wmsqr.data.auth.api.ApiClient
import com.sharom.wmsqr.domain.box.model.ScanRepository

class ScanActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = ScanRepository(ApiClient.boxApi)
        val vmFactory = ScanVmFactory(repo)

        setContent {
            val vm: ScanViewModel = viewModel(factory = vmFactory)

            ScanScreen(vm)
        }
    }
}