package ar.edu.ort.trabajopractico.screens.profilepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.profilepage.SettingsItem
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun SecurityScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Security",
            style = AppTypography.sectionTitle
        )

        SettingsItem("Change Password", R.drawable.security) {
             navController.navigate("change_password")
        }
        SettingsItem("Change Email", R.drawable.security) {
             navController.navigate("change_email")
        }
    }
}