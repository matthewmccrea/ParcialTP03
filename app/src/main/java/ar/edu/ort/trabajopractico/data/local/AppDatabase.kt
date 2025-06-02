package ar.edu.ort.trabajopractico.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ar.edu.ort.trabajopractico.data.local.FavouriteProduct
import ar.edu.ort.trabajopractico.data.local.FavouriteProductDao

@Database(
    entities = [FavouriteProduct::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteProductDao(): FavouriteProductDao
}