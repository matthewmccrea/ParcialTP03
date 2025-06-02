package ar.edu.ort.trabajopractico.data
import androidx.annotation.DrawableRes


data class Product(
    val id: Int,
    val name: String,
    val price: String,
    @DrawableRes val imageRes: Int
)