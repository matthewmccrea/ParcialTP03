package ar.edu.ort.trabajopractico.screens.profilepage
import androidx.compose.foundation.background
import ar.edu.ort.trabajopractico.components.profilepage.NotificationToggle

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import androidx.compose.ui.text.font.FontWeight
import ar.edu.ort.trabajopractico.ui.theme.AppTypography


@Composable
fun NotificationScreen(navController:NavController) {
    var likedPost by remember { mutableStateOf(true) }
    var newMessage by remember { mutableStateOf(true) }
    var itemSold by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Notifications",
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

        Text("Social", style = AppTypography.sectionTitle)
        NotificationToggle("Liked Post", likedPost) { likedPost = it }
        NotificationToggle("New Message", newMessage) { newMessage = it }

        Spacer(modifier = Modifier.height(24.dp))

        Text("Store", style = AppTypography.sectionTitle)
        NotificationToggle("Item Sold", itemSold) { itemSold = it }
    }
}


