package com.sharom.wmsqr

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.sharom.wmsqr.data.auth.SessionManager
import com.sharom.wmsqr.data.auth.TokenManager
import com.sharom.wmsqr.ui.navigation.AppNav
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            TokenManager.getToken(applicationContext).collect { token ->
                SessionManager.accessToken = token
            }
        }


        setContent {

            AppNav()

        }
    }



}

