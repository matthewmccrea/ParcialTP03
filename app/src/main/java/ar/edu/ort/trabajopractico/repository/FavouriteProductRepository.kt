package ar.edu.ort.trabajopractico.repository

import ar.edu.ort.trabajopractico.data.local.FavouriteProduct
import ar.edu.ort.trabajopractico.data.local.FavouriteProductDao
import kotlinx.coroutines.flow.Flow

class FavouriteProductRepository(
    private val dao: FavouriteProductDao
) {
    fun getAllFavorites(): Flow<List<FavouriteProduct>> {
        return dao.getAllFavorites()
    }

    suspend fun insertFavorite(product: FavouriteProduct) {
        dao.insertFavorite(product)
    }

    suspend fun deleteFavorite(product: FavouriteProduct) {
        dao.deleteFavorite(product)
    }

    fun isFavorite(productId: String): Flow<Boolean> {
        return dao.isFavorite(productId)
    }
}