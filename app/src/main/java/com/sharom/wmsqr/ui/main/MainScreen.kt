package com.sharom.wmsqr.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sharom.wmsqr.R
import com.sharom.wmsqr.ui.box.BoxScreen
import com.sharom.wmsqr.ui.home.HomeScreen
import com.sharom.wmsqr.ui.navigation.BottomNavItem
import com.sharom.wmsqr.ui.profile.ProfileScreen
import com.sharom.wmsqr.ui.truck.TruckScreen

@Composable
fun MainScreen(onLogout: () -> Unit) {

    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem("home", "Home", painterResource(R.drawable.home_24dp)),
        BottomNavItem("truck", "Truck", painterResource(R.drawable.local_shipping_24dp)),
        BottomNavItem("box", "Box", painterResource(R.drawable.inventory_2_24dp)),
        BottomNavItem("profile", "Profile", painterResource(R.drawable.account_box_24dp))
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val currentRoute = currentRoute(navController)

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,

                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                                restoreState = true
                                popUpTo("home") { saveState = true }
                            }
                        },
                        icon = {
                            Icon(item.icon, contentDescription = item.label)
                        },
                        label = { Text(item.label) }
                    )

                }
            }
        }
    ) {
            innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen() }
            composable("truck") { TruckScreen() }
            composable("box") { BoxScreen() }
            composable("profile") { ProfileScreen(onLogout) }
        }
    }



//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(24.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        Text(
//            text = "Wellcome to Main Screen",
//            style = MaterialTheme.typography.headlineMedium
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(onClick = onLogout) {
//            Text("Logout")
//        }
//
//    }
}