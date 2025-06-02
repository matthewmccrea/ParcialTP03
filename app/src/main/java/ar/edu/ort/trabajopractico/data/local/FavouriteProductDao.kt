package ar.edu.ort.trabajopractico.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(product: FavouriteProduct)

    @Delete
    suspend fun deleteFavorite(product: FavouriteProduct)

    @Query("SELECT * FROM favorite_products")
    fun getAllFavorites(): Flow<List<FavouriteProduct>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_products WHERE id = :productId)")
    fun isFavorite(productId: String): Flow<Boolean>
}