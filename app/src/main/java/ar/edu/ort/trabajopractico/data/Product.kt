package ar.edu.ort.trabajopractico.data
import androidx.annotation.DrawableRes



data class Product(
    val id: Int,
    val title: String?,
    val price: String?,
    val description: String? ,
    @DrawableRes val imageRes: Int
)