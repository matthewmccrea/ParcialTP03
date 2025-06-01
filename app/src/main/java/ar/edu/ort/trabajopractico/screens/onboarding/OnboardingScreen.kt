package ar.edu.ort.trabajopractico.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.navigation.LeafScreen

@Composable
fun OnboardingScreen(navController: NavController) {
    val purpleColor = Color(0xFF8A56AC) // violeta como en el diseño

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Meet your\nanimal needs\nhere",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Start,
                lineHeight = 38.sp,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(32.dp))

            Image(
                painter = painterResource(id = R.drawable.icon_onboarding),
                contentDescription = "Onboarding Illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp) // más grande
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Get interesting promos here, register your\naccount immediately so you can meet your\nanimal needs.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Dot(isSelected = true, color = purpleColor)
                Spacer(modifier = Modifier.width(6.dp))
                Dot(isSelected = false, color = purpleColor)
                Spacer(modifier = Modifier.width(6.dp))
                Dot(isSelected = false, color = purpleColor)
            }
        }

        Button(
            onClick = { navController.navigate(LeafScreen.Login.route) },
            colors = ButtonDefaults.buttonColors(containerColor = purpleColor),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Get Started", fontSize = 16.sp)
        }
    }
}

@Composable
fun Dot(isSelected: Boolean, color: Color) {
    Box(
        modifier = Modifier
            .size(if (isSelected) 10.dp else 8.dp)
            .padding(2.dp)
            .background(
                color = if (isSelected) color else color.copy(alpha = 0.3f),
                shape = RoundedCornerShape(50)
            )
    )
}
