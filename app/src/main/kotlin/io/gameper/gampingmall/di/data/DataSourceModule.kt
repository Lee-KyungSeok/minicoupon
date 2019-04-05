package io.gameper.gampingmall.di.data

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.data.local.product.ProductLocalDataSource
import io.gameper.gampingmall.data.local.product.dao.ProductDao
import io.gameper.gampingmall.data.remote.product.ProductRemoteDataSource
import io.gameper.gampingmall.data.remote.product.api.ProductApi
import javax.inject.Singleton

@Module
class DataSourceModule {
    @Provides
    @Singleton
    fun provideGiftRemoteDataSource(api: ProductApi): ProductRemoteDataSource = ProductRemoteDataSource(api)

    @Provides
    @Singleton
    fun provideGiftLocalDataSource(dao: ProductDao): ProductLocalDataSource = ProductLocalDataSource(dao)
}