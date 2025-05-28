package ar.edu.ort.trabajopractico.screens.onboarding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import ar.edu.ort.trabajopractico.navigation.LeafScreen
@Composable
fun OnboardingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Onboarding Page",
            fontSize = 32.sp,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(LeafScreen.Login.route)
            }
        ) {
            Text("Comenzar")
        }
    }
}