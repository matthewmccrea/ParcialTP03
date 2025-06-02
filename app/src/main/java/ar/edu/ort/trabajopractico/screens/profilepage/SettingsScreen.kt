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
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {

        Text("Account", style = AppTypography.sectionTitle)
        SettingsItem("Account", R.drawable.profile) {
            navController.navigate("account")
        }
        SettingsItem("Address", R.drawable.home) {
        }
        SettingsItem("Notification", R.drawable.notification) {
            navController.navigate("notification")
        }
        SettingsItem("Payment Method", R.drawable.wallet) {
            navController.navigate("payment_method")
        }
        SettingsItem("Privacy", R.drawable.danger_circle) {
            navController.navigate("privacy")
        }
        SettingsItem("Security", R.drawable.security) {
            navController.navigate("security")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Help" ,style = AppTypography.sectionTitle)
        SettingsItem("Contact Us", R.drawable.contact_us) {
        }
        SettingsItem("FAQ", R.drawable.faq) {
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

