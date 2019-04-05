package io.gameper.gampingmall.di.data

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.data.gateway.GiftShopGatewayImpl
import io.gameper.gampingmall.data.gateway.mapper.EntityModelMapper
import io.gameper.gampingmall.data.repository.ProductRepository
import io.gameper.gampingmall.data.repository.TradeRepository
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import javax.inject.Singleton

@Module(
    includes = [
        ApiModule::class,
        LocalDataModule::class,
        NetworkModule::class,
        DataSourceModule::class,
        RepositoryModule::class]
)
class DataModule {

    @Provides
    @Singleton
    fun providesGiftShopGateway(
        productRepository: ProductRepository,
        tradeRepository: TradeRepository,
        entityModelMapper: EntityModelMapper
    ): GiftShopGateway {
        return GiftShopGatewayImpl(productRepository, tradeRepository, entityModelMapper)
    }

    @Provides
    @Singleton
    fun providesGiftModelMapper(): EntityModelMapper = EntityModelMapper()
}