package ar.edu.ort.trabajopractico.screens.profilepage

import AccountViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.AppTextField
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.components.profilepage.HeaderSection
import ar.edu.ort.trabajopractico.ui.theme.AppTypography

@Composable
fun AccountScreen(navController: NavController,
                  viewModel: AccountViewModel = viewModel()
) {
    var name by viewModel.name
    var username by viewModel.username
    var email by viewModel.email

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Account",
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(48.dp)
                    .background(Color(0xFFF8F8F8), shape = CircleShape)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
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
                    onValueChange = { viewModel.name.value = it },
                    placeholder = "Name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )

                Text(text = "Username", style = AppTypography.settingsItem)
                AppTextField(
                    value = username,
                    onValueChange = { viewModel.username.value = it },
                    placeholder = "Username",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                )

                Text(text = "Email", style = AppTypography.settingsItem)
                AppTextField(
                    value = email,
                    onValueChange = { viewModel.email.value = it },
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




