package ar.edu.ort.trabajopractico.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.navigation.LeafScreen
import ar.edu.ort.trabajopractico.ui.theme.PurpleButton

@Composable
fun OnboardingScreen(navController: NavController) {
    val purpleColor = Color(0xFF8A56AC)

    val pages = listOf(
        OnboardingPage(
            title = "Meet your\n\nanimal needs\n\nhere",
            description = "Get interesting promos here, register your\naccount immediately so you can meet your\nanimal needs.",
            imageRes = R.drawable.icon_onboarding
        ),
        OnboardingPage(
            title = "Adopt or help\n\nanimals \n\nin need",
            description = "Support animal shelters or adopt your\nnew best friend today.",
            imageRes = R.drawable.onboarding_2
        ),
        OnboardingPage(
            title = "Find nearby\n\npet services",
            description = "Grooming, walking, veterinary – find\nwhat your pet needs near you.",
            imageRes = R.drawable.onboarding_3
        )
    )

    var currentPage by remember { mutableStateOf(0) }
    val page = pages[currentPage]

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
                text = page.title,
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Start,
                lineHeight = 38.sp,
                style = MaterialTheme.typography.titleLarge

            )

            Spacer(modifier = Modifier.height(37.dp))

            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = "Onboarding Illustration",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = page.description,
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
                pages.forEachIndexed { index, _ ->
                    Dot(
                        isSelected = index == currentPage,
                        color = PurpleButton,
                        onClick = { currentPage = index }
                    )
                    if (index < pages.lastIndex) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }

        Button(
            onClick = { navController.navigate(LeafScreen.Login.route) },
            colors = ButtonDefaults.buttonColors(containerColor = PurpleButton),
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
fun Dot1(isSelected: Boolean, color: Color, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(16.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(if (isSelected) 10.dp else 8.dp)
                .clip(RoundedCornerShape(50))
                .background(
                    color = if (isSelected) color else color.copy(alpha = 0.3f)
                )
        )
    }
}
