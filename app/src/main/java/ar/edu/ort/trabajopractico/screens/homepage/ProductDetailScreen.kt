package ar.edu.ort.trabajopractico.screens.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.PrimaryButton
import ar.edu.ort.trabajopractico.components.QuantitySelector
import ar.edu.ort.trabajopractico.data.Product

@Composable
fun ProductDetailScreen(
    navController: NavController,
    product: Product,
    onAddToCart: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        // Top bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFF8F8F8), shape = CircleShape)
                    .shadow(4.dp, CircleShape)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }

            Text(
                text = "Product Detail",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            IconButton(
                onClick = { /* Like logic */ },
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFF8F8F8), shape = CircleShape)
                    .shadow(4.dp, CircleShape)
            ) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "Like")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFF8F8F8)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = product.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))


        Text(
            text = "The Persian cat has the longest and densest coat of all cat breeds. This means that it typically needs to consume more skin-health focused nutrients than other cat breeds. That’s why ROYAL CANIN® Persian Adult contains an exclusive complex of nutrients to help the skin’s barrier defence role to maintain good skin and coat health.",
            fontSize = 13.sp,
            lineHeight = 18.sp,
            color = Color(0xFFB3B1B0)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Quantity and Price
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuantitySelector()

            Text(
                text = "$${product.price}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        PrimaryButton(
            text = "Add to Cart",
            onClick = onAddToCart,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}