package ar.edu.ort.trabajopractico.screens.login

import ForgotPasswordViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.navigation.LeafScreen

@Composable
fun ForgotPasswordEmailScreen(navController: NavController,
                              viewModel: ForgotPasswordViewModel = viewModel())
{
    var email by viewModel.email
    val isEmailValid = viewModel.isEmailValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            Text("Forgot", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text("Password", fontSize = 32.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Water is life. Water is a basic human need. In various lines of life, humans need water.",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { viewModel.email.value = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = email.isNotBlank() && !isEmailValid
            )

            if (email.isNotBlank() && !isEmailValid) {
                Text(
                    "Invalid email format",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = {
                navController.navigate(LeafScreen.Login.route)
            }) {
                Text("Have an account? ", color = Color.Gray)
                Text("Login", color = MaterialTheme.colorScheme.primary)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    navController.navigate(LeafScreen.ResetPassword.route)
                },
                enabled = isEmailValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text("Next")
            }
        }
    }
}
