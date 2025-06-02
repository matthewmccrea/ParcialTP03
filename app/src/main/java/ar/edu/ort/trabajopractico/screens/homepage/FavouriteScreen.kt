package ar.edu.ort.trabajopractico.screens.homepage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ar.edu.ort.trabajopractico.components.FavouriteItem
import ar.edu.ort.trabajopractico.viewmodels.FavouriteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouriteScreen(navController:NavController,
    viewModel: FavouriteViewModel = hiltViewModel()
) {
    val favourites by viewModel.favouriteProducts.collectAsState()

    Scaffold(

    ) { paddingValues ->
        if (favourites.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("No tenés productos favoritos todavía.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(favourites) { product ->
                    FavouriteItem(product = product) {
                        viewModel.removeFavourite(product)
                    }
                }
            }
        }
    }
}

