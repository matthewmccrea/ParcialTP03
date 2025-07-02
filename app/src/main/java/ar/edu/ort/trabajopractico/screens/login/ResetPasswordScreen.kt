package ar.edu.ort.trabajopractico.screens.login

import ResetPasswordViewModel
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
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ResetPasswordScreen(navController: NavHostController, viewModel: ResetPasswordViewModel = viewModel()) {
    var newPassword by viewModel.newPassword
    var confirmPassword by viewModel.confirmPassword

    val isPasswordValid = viewModel.isPasswordValid
    val doPasswordsMatch = viewModel.newPassword == viewModel.confirmPassword
    val isFormValid = viewModel.isPasswordValid && viewModel.doPasswordsMatch

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

            // New Password
            OutlinedTextField(
                value = newPassword,
                onValueChange = { viewModel.newPassword.value = it },
                label = { Text("New Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = newPassword.isNotBlank() && !isPasswordValid
            )
            if (newPassword.isNotBlank() && !isPasswordValid) {
                Text(
                    "Password must be at least 6 characters",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Confirm Password
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = confirmPassword.isNotBlank() && !doPasswordsMatch
            )
            if (confirmPassword.isNotBlank() && !doPasswordsMatch) {
                Text(
                    "Passwords do not match",
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextButton(onClick = {
                navController.navigate("login") // O usá LeafScreen.Login.route si corresponde
            }) {
                Text("Have an account? ", color = Color.Gray)
                Text("Login", color = MaterialTheme.colorScheme.primary)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    // Acá podés mandar la nueva contraseña al backend o lógica correspondiente
                },
                enabled = isFormValid,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text("Reset Password")
            }
        }
    }
}
