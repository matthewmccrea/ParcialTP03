package ar.edu.ort.trabajopractico.screens.login

import CreateAccountViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun CreateAccountScreen(navController: NavHostController,
                        viewModel: CreateAccountViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val fullName by viewModel.fullName
    val email by viewModel.email
    val password by viewModel.password
    val acceptedTerms by viewModel.acceptedTerms

    val fullNameError by viewModel.fullNameError
    val emailError by viewModel.emailError
    val passwordError by viewModel.passwordError

    val allFieldsValid = viewModel.allFieldsValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Create New\nAccount",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Water is life. Water is a basic human need...",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(24.dp))

        CustomTextField(
            value = fullName,
            onValueChange = {
                viewModel.fullName.value = it
                viewModel.fullNameError.value = it.isBlank()
            },
            label = "Full Name",
            isError = fullNameError
        )

        Spacer(modifier = Modifier.height(12.dp))

        CustomTextField(
            value = email,
            onValueChange = {
                viewModel.email.value = it
                viewModel.emailError.value = it.isBlank()
            },
            label = "Email",
            keyboardType = KeyboardType.Email,
            isError = emailError
        )

        Spacer(modifier = Modifier.height(12.dp))

        CustomTextField(
            value = password,
            onValueChange = {
                viewModel.password.value = it
                viewModel.passwordError.value = it.isBlank()
            },
            label = "Password",
            keyboardType = KeyboardType.Password,
            isError = passwordError
        )

        if (passwordError) {
            Text(
                text = "\uD83D\uDCC5 Required Fields",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = acceptedTerms,
                onCheckedChange = { viewModel.acceptedTerms.value = it },
                colors = CheckboxDefaults.colors(checkedColor = Color(0xFF8A2BE2))
            )
            Text(
                text = "I agree to the Terms of Service and\nPrivacy Policy",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Acciones de creación */ },
            enabled = allFieldsValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (allFieldsValid) Color(0xFF8A2BE2) else Color.LightGray
            )
        ) {
            Text("Get Started")
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    isError: Boolean = false
) {
    val focusedColor = Color(0xFF8A2BE2)
    val errorColor = Color.Red

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = if (isError) errorColor else focusedColor) },
        singleLine = true,
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = focusedColor,
            unfocusedBorderColor = Color.LightGray,
            errorBorderColor = errorColor
        ),
        modifier = Modifier.fillMaxWidth()
    )
}
