package ar.edu.ort.trabajopractico.screens.profilepage


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.profilepage.SettingsItem

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text("Account", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        SettingsItem("Account", R.drawable.icon_user) {
            navController.navigate("account")
        }
        SettingsItem("Address", R.drawable.icon_home) {
        }
        SettingsItem("Notification", R.drawable.settings) {
            navController.navigate("notification")
        }
        SettingsItem("Payment Method", R.drawable.settings) {
            navController.navigate("payment_method")
        }
        SettingsItem("Privacy", R.drawable.settings) {
            navController.navigate("privacy")
        }
        SettingsItem("Security", R.drawable.settings) {
            navController.navigate("security")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Help", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        SettingsItem("Contact Us", R.drawable.settings) {
        }
        SettingsItem("FAQ", R.drawable.settings) {
            navController.navigate("faq")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { /* TODO: Logout */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFF7140FD))
        ) {
            Text("Log Out", color = Color(0xFF7140FD), fontWeight = FontWeight.Bold)
        }
    }
}

