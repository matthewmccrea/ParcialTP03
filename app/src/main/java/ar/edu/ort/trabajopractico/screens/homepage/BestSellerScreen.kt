package ar.edu.ort.trabajopractico.screens.homepage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.ProductGrid
import ar.edu.ort.trabajopractico.data.Product

@Composable
fun BestSellerScreen(
    navController: NavController
) {
    val mockProducts = listOf(
        Product("RC Kitten", "20,99",R.drawable.kitten_food1),
        Product("RC Persian", "22,99",R.drawable.persian_cat),
        Product("RC Kitten", "20,99",R.drawable.kitten_food1),
        Product("RC Persian", "22,99",R.drawable.persian_cat),
        Product("RC Kitten", "20,99",R.drawable.kitten_food1),
        Product("RC Persian", "22,99",R.drawable.persian_cat)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Best Seller",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        ProductGrid(products = mockProducts,  onProductClick = {  })
    }
}