package ar.edu.ort.trabajopractico.data

import androidx.annotation.DrawableRes

data class CartProduct(
    val id: Int,
    val title: String,
    val price: Double,
    val quantity: Int,
    val total: Double,
    val discountPercentage: Double,
    val discountedTotal: Double,
    @DrawableRes val imageRes: Int
)