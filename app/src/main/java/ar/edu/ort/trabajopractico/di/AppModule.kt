package ar.edu.ort.trabajopractico.di

import android.content.Context
import androidx.room.Room
import ar.edu.ort.trabajopractico.data.local.AppDatabase
import ar.edu.ort.trabajopractico.data.local.FavouriteProductDao
import ar.edu.ort.trabajopractico.repository.FavouriteProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "favorites_db"
        ).build()
    }


    @Provides
    fun provideFavoriteProductDao(db: AppDatabase): FavouriteProductDao {
        return db.favoriteProductDao()
    }

    @Provides
    @Singleton
    fun provideFavouriteProductRepository(dao: FavouriteProductDao): FavouriteProductRepository {
        return FavouriteProductRepository(dao)
    }
}
