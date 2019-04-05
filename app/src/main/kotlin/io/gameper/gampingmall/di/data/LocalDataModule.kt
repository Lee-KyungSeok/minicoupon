package io.gameper.gampingmall.di.data

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.data.local.product.dao.ProductDao
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun providesGiftDao() : ProductDao = ProductDao()

//    @Provides
//    @Singleton
//    fun provideDatabase(@Named("appContext") context: Context) : Database
//    = Room.databaseBuilder(context, Database::class.java, DB_NAME).build()

    companion object {
        const val DB_NAME = "database"
    }
}