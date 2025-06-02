package ar.edu.ort.trabajopractico.screens.homepage
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.Banner
import ar.edu.ort.trabajopractico.components.HomeButtons
import ar.edu.ort.trabajopractico.components.ProductGrid
import ar.edu.ort.trabajopractico.components.TopBarLocation
import ar.edu.ort.trabajopractico.data.Product
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.ProductCard
import ar.edu.ort.trabajopractico.navigation.LeafScreen

@Composable
fun HomeScreenScaffold(navController: NavController) {
    val mockProducts = listOf(
        Product("RC Kitten", "20,99", R.drawable.kitten_food1),
        Product("RC Persian", "22,99", R.drawable.persian_cat)
    )

    Scaffold(
        topBar = {
            TopBarLocation(navController)
        }
    ) { paddingValues ->

        LazyColumn(
            contentPadding = paddingValues
        ) {
            item {
                Banner()
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Category",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 28.8.sp,
                        color = Color.Black
                    )

                    Text(
                        text = "View All",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 19.2.sp,
                        color = Color(0xFF7140FD),
                        modifier = Modifier.clickable {

                        }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))


            }
            item {
                HomeButtons(
                    selectedCategory = "Food",
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Best Seller",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 28.8.sp,
                        color = Color.Black
                    )

                    Text(
                        text = "View All",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 19.2.sp,
                        color = Color(0xFF7140FD),
                        modifier = Modifier.clickable {
                            navController.navigate(LeafScreen.BestSeller.route)
                        }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ProductCard(
                        imageRes = R.drawable.kitten_food1,
                        name = "RC Kitten",
                        price = "20,99",
                        onAddClick = {}
                    )

                    ProductCard(
                        imageRes = R.drawable.kitten_food1,
                        name = "RC Persian",
                        price = "22,99",
                        onAddClick = {}
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

        }

    }
}
