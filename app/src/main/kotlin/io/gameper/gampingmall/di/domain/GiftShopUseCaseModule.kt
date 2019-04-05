package io.gameper.gampingmall.di.domain

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.domain.interactor.product.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class GiftShopUseCaseModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(@Named("appScheduler")schedulers: Schedulers,
                                gateway: GiftShopGateway) : GetProductAllUseCase =
        GetProductAllUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideGetEventProductsUseCase(@Named("appScheduler")schedulers: Schedulers,
                                gateway: GiftShopGateway) : GetEventProductsUseCase =
        GetEventProductsUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideGetSaleProductsUseCase(@Named("appScheduler")schedulers: Schedulers,
                                gateway: GiftShopGateway) : GetSaleProductsUseCase =
        GetSaleProductsUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideOrderProductsUseCase(@Named("appScheduler")schedulers: Schedulers,
                                     gateway: GiftShopGateway): OrderProductsUseCase =
        OrderProductsUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideGiftingOrderUseCase(@Named("appScheduler")schedulers: Schedulers,
                                     gateway: GiftShopGateway): GiftingOrderUseCase =
        GiftingOrderUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideGetOrdersUseCase(@Named("appScheduler")schedulers: Schedulers,
                                 gateway: GiftShopGateway): GetOrdersUseCase =
        GetOrdersUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun providePayProductsUseCase(@Named("appScheduler")schedulers: Schedulers,
                                     gateway: GiftShopGateway): PayProductsUseCase =
        PayProductsUseCase(schedulers, gateway)

    @Provides
    @Singleton
    fun provideChangeProductStatusUseCase(@Named("appScheduler")schedulers: Schedulers,
                                  gateway: GiftShopGateway): ChangeProductStatusUseCase =
        ChangeProductStatusUseCase(schedulers, gateway)
}