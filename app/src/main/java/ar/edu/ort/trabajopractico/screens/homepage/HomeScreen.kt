package ar.edu.ort.trabajopractico.screens.homepage
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.Banner
import ar.edu.ort.trabajopractico.components.HomeButtons
import ar.edu.ort.trabajopractico.components.ProductGrid
import ar.edu.ort.trabajopractico.components.TopBarLocation
import ar.edu.ort.trabajopractico.data.Product
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.components.ProductCard
import ar.edu.ort.trabajopractico.data.local.FavouriteProduct
import ar.edu.ort.trabajopractico.navigation.LeafScreen
import ar.edu.ort.trabajopractico.viewmodels.FavouriteViewModel
import ar.edu.ort.trabajopractico.viewmodels.ProductViewModel

@Composable
fun HomeScreenScaffold(
    navController: NavController,
    favouriteViewModel: FavouriteViewModel = hiltViewModel(),
    productViewModel: ProductViewModel = hiltViewModel()
) {
    val favourites by favouriteViewModel.favouriteProducts.collectAsState()
    val products by productViewModel.products.collectAsState()
    val isLoading by productViewModel.isLoading.collectAsState()

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
                if (isLoading) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        products.take(2).forEach { product ->
                            val isFavourite = favourites.any { it.id == product.id.toString() }

                            ProductCard(
                                imageRes = product.imageRes,
                                name = product.title ?: "",
                                price = product.price ?: "",
                                isFavourite = isFavourite,
                                onAddClick = { },
                                onFavouriteClick = {
                                    favouriteViewModel.toggleFavourite(
                                        FavouriteProduct(
                                            id = product.id.toString(),
                                            name = product.title ?: "",
                                            price = product.price ?: "",
                                            imageRes = product.imageRes
                                        )
                                    )
                                }

                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
