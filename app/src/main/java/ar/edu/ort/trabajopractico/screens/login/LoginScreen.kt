package ar.edu.ort.trabajopractico.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.navigation.LeafScreen
import ar.edu.ort.trabajopractico.viewModels.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = viewModel()) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val purple = Color(0xFF8A56AC)
    val lightGray = Color(0xFFE5E5E5)
    val red = Color(0xFFE53935)

    val showPasswordError = username.isNotBlank() && password.isBlank()
    val showEmailError = username.isBlank() && password.isNotBlank()

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val isLoading by viewModel.isLoading.collectAsState()
    val loginResult by viewModel.loginResult.collectAsState()

    LaunchedEffect(loginResult) {
        if (loginResult == true) {
            navController.navigate(LeafScreen.Home.route) {
                popUpTo(LeafScreen.Login.route) { inclusive = true }
            }
        } else if (loginResult == false) {
            scope.launch {
                snackBarHostState.showSnackbar("Login failed. Check your credentials.")
            }
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        }
    ) { padding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 24.dp)
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Hello,\nWelcome Back!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    lineHeight = 36.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Water is life. Water is a basic human need. In various lines of life, humans need water.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text("Username") },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    isError = showEmailError,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (showEmailError) red else purple,
                        unfocusedBorderColor = if (showEmailError) red else lightGray,
                        cursorColor = purple
                    ),
                    enabled = !isLoading
                )

                if (showEmailError) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Error",
                            tint = red,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Required Fields",
                            color = red,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text("Password") },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    isError = showPasswordError,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = if (showPasswordError) red else purple,
                        unfocusedBorderColor = if (showPasswordError) red else lightGray,
                        cursorColor = purple
                    ),
                    enabled = !isLoading
                )

                if (showPasswordError) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Error",
                            tint = red,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Required Fields",
                            color = red,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(
                    onClick = { navController.navigate(LeafScreen.ForgotPasswordEmail.route) },
                    modifier = Modifier.align(Alignment.End),
                    enabled = !isLoading
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = purple,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    HorizontalDivider(modifier = Modifier.weight(1f), color = lightGray)
                    Text(
                        text = "or",
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = lightGray
                    )
                    HorizontalDivider(modifier = Modifier.weight(1f), color = lightGray)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedButton(
                        onClick = { /* TODO: Google login */ },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, lightGray),
                        modifier = Modifier.weight(1f),
                        enabled = !isLoading
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Google", fontSize = 14.sp)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    OutlinedButton(
                        onClick = { /* TODO: Facebook login */ },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, lightGray),
                        modifier = Modifier.weight(1f),
                        enabled = !isLoading
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_facebook),
                            contentDescription = "Facebook",
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Facebook", fontSize = 14.sp)
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        if (username.isBlank() || password.isBlank()) {
                            scope.launch {
                                snackBarHostState.showSnackbar("Please complete all required fields.")
                            }
                        } else {
                            viewModel.login(username, password)
                        }
                    },
                    enabled = !isLoading && username.isNotBlank() && password.isNotBlank(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (username.isNotBlank() && password.isNotBlank()) purple else lightGray,
                        contentColor = Color.White,
                        disabledContainerColor = lightGray,
                        disabledContentColor = Color.DarkGray
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 2.dp,
                        disabledElevation = 0.dp
                    )
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp
                        )
                    } else {
                        Text(
                            text = "Get Started",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Don't have an account?",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(
                        onClick = { navController.navigate(LeafScreen.CreateAccount.route) },
                        enabled = !isLoading
                    ) {
                        Text(
                            text = "Create Account",
                            color = purple,
                            fontSize = 14.sp
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Go to Sign Up",
                            tint = purple,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}
