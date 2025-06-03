package ar.edu.ort.trabajopractico.screens.homepage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {

        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Mis favoritos",
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
}

