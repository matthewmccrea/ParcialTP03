package ar.edu.ort.trabajopractico.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.data.Product
import ar.edu.ort.trabajopractico.data.api.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor() : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.productApi.getProducts()
                if (response.isSuccessful) {
                    _products.value = response.body()?.products?.mapIndexed { index, it ->
                        Product(
                            id = it.id,
                            title = it.title ?: "",
                            price = it.price.toString(),
                            description = it.description ?: "",
                            imageRes = if (index % 2 == 0) R.drawable.kitten_food1 else R.drawable.persian_cat

                        )

                    } ?: emptyList()
                } else {
                    _products.value = emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _products.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

}