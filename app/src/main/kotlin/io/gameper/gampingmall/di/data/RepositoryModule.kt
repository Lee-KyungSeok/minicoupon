package io.gameper.gampingmall.di.data

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.data.local.product.ProductLocalDataSource
import io.gameper.gampingmall.data.remote.product.ProductRemoteDataSource
import io.gameper.gampingmall.data.repository.ProductRepository
import io.gameper.gampingmall.data.repository.TradeRepository
import io.gameper.gampingmall.data.repository.mapper.RemoteModelMapper
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesGiftRepository(
        productLocalDataSource: ProductLocalDataSource,
        productRemoteDataSource: ProductRemoteDataSource,
        remoteModelMapper: RemoteModelMapper
    ): ProductRepository {

        return ProductRepository(productLocalDataSource, productRemoteDataSource, remoteModelMapper)
    }

    @Provides
    @Singleton
    fun providesGiftRemoteMapper() : RemoteModelMapper = RemoteModelMapper()

    @Provides
    @Singleton
    fun providesTradeRepository(): TradeRepository = TradeRepository()

}