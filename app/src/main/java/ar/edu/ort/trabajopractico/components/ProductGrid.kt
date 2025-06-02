package ar.edu.ort.trabajopractico.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.ort.trabajopractico.data.Product


import androidx.compose.foundation.layout.fillMaxSize

import ar.edu.ort.trabajopractico.data.local.FavouriteProduct
import ar.edu.ort.trabajopractico.viewmodels.FavouriteViewModel

@Composable
fun ProductGrid(
    products: List<Product>,
    favouriteViewModel: FavouriteViewModel,
    modifier: Modifier = Modifier,
    onProductClick: (Product) -> Unit = {}
) {
    val favourites = favouriteViewModel.favouriteProducts.collectAsState().value

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products) { product ->
            val isFavourite = favourites.any { it.id == product.id.toString() }

            ProductCard(
                imageRes = product.imageRes,
                name = product.name,
                price = product.price,
                isFavourite = isFavourite,
                onAddClick = { /* acción al agregar */ },
                onFavouriteClick = {
                    favouriteViewModel.toggleFavourite(
                        FavouriteProduct(
                            id = product.id.toString(),
                            name = product.name,
                            price = product.price,
                            imageRes = product.imageRes
                        )
                    )
                }
            )
        }
    }
}

