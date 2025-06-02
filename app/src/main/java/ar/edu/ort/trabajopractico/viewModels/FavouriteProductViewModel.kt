package ar.edu.ort.trabajopractico.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.data.local.FavouriteProduct
import ar.edu.ort.trabajopractico.repository.FavouriteProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: FavouriteProductRepository
) : ViewModel() {

    val favouriteProducts: StateFlow<List<FavouriteProduct>> =
        repository.getAllFavorites()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )

    fun addFavourite(product: FavouriteProduct) {
        viewModelScope.launch {
            repository.insertFavorite(product)
        }
    }

    fun removeFavourite(product: FavouriteProduct) {
        viewModelScope.launch {
            repository.deleteFavorite(product)
        }
    }

    fun isFavourite(productId: String): StateFlow<Boolean> {
        return repository.isFavorite(productId)
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                false
            )
    }

    fun toggleFavourite(product: FavouriteProduct) {
        viewModelScope.launch {
            val isFav = repository.isFavorite(product.id).first()
            if (isFav) {
                removeFavourite(product)
            } else {
                addFavourite(product)
            }
        }
    }
}