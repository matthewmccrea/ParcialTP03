package ar.edu.ort.trabajopractico.data.api

import ar.edu.ort.trabajopractico.data.CartProduct

data class CartResponse(
    val id: Int,
    val products: List<CartProduct>
)