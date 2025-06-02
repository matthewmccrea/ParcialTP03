package ar.edu.ort.trabajopractico.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_products")
data class FavouriteProduct(
    @PrimaryKey(autoGenerate = false) val id: String,
    val name: String,
    val price: String,
    val imageRes: Int
)
