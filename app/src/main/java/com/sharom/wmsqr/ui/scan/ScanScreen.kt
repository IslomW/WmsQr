package com.sharom.wmsqr.ui.scan

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sharom.wmsqr.ui.ScanResult

fun ScanScreen(vm: ScanViewModel) {

    var input by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {

        Text("Scanned: ${vm.scannedCount} / ${vm.boxes.size}")

        Spacer(Modifier.height(12.dp))

        TextField(
            value = input,
            onValueChange = {
                input = it

                if (it.endsWith("\n")) {
                    val code = it.trim()
                    val result = vm.onScan(code)

                    when(result) {
                        ScanResult.OK -> beepOk()
                        ScanResult.NOT_FOUND -> beepError()
                        ScanResult.ALREADY_SCANNED -> beepWarn()
                    }

                    input = ""
                }
            },
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(vm.boxes) { box ->
                Text(
                    box.boxId +
                            if (box.scanned) " ✅" else ""
                )
            }
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { vm.confirmAll {} }
        ) {
            Text("Confirm")
        }
    }
}