package com.sharom.wmsqr.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue

@Composable
fun ProfileScreen(
    onLogout: () -> Unit,
    userViewModel: UserViewModel = viewModel()
) {

    val user by userViewModel.user.collectAsState()

    LaunchedEffect(Unit) {
        userViewModel.loadUser()
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {


        Text(
            text = "Profile",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                if (user == null) {
                    Text("Loading...")
                } else {
                    ProfileRow(label = "Name", value = user!!.name ?: "-")
                    Divider()
                    ProfileRow(label = "Phone", value = user!!.phone ?: "-")
                    Divider()
                    ProfileRow(label = "Role", value = user!!.userType ?: "-")
                    Divider()
                    ProfileRow(label = "Warehouse", value = user!!.locationId ?: "-")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }

    }
}

@Composable
fun ProfileRow(label: String, value: String) {
    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text(text = label)
        Text(text = value)
    }
}