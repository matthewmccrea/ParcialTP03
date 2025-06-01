package ar.edu.ort.trabajopractico.screens.profilepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.PrimaryButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.ui.theme.AppTypography
import ar.edu.ort.trabajopractico.ui.theme.components.AppTextField
import ar.edu.ort.trabajopractico.components.profilepage.HeaderSection

@Composable
fun AccountScreen(navController: NavController) {
    var name by remember { mutableStateOf("Abdul") }
    var username by remember { mutableStateOf("Abduldul") }
    var email by remember { mutableStateOf("abdul@example.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            HeaderSection(
                isSeller = false,
                username = username,
                onToggleMode = {},
                isEdit =true,
                navController = navController
            )

        }

            Spacer(modifier = Modifier.height(5.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Name", style = AppTypography.settingsItem)
                AppTextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = "Name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )

                Text(text = "Username", style = AppTypography.settingsItem)
                AppTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Username",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )

                Text(text = "Email", style = AppTypography.settingsItem)
                AppTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = "Email",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )
            }
            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(
                text = "Save Changes",
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            )

    }
}




