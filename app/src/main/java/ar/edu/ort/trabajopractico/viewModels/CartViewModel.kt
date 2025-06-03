package ar.edu.ort.trabajopractico.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.trabajopractico.R
import ar.edu.ort.trabajopractico.data.CartProduct
import ar.edu.ort.trabajopractico.data.api.RetrofitClient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor() : ViewModel() {

    private val _cartProducts = MutableStateFlow<List<CartProduct>>(emptyList())
    val cartProducts: StateFlow<List<CartProduct>> = _cartProducts

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchCart()
    }

    fun fetchCart() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitClient.cartApi.getCart()
                if (response.isSuccessful) {
                    val original = response.body()?.products ?: emptyList()

                    _cartProducts.value = original.mapIndexed { index, it ->
                        CartProduct(
                            id = it.id,
                            title = it.title,
                            price = it.price,
                            quantity = it.quantity,
                            total = it.total,
                            discountPercentage = it.discountPercentage,
                            discountedTotal = it.discountedTotal,
                            imageRes = if (index % 2 == 0) R.drawable.kitten_food1 else R.drawable.persian_cat
                        )
                    }
                } else {
                    _cartProducts.value = emptyList()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _cartProducts.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }
}