package io.gameper.gampingmall.di.domain

import io.gameper.gampingmall.domain.interactor.product.*

interface GiftShopUseCaseDependency {
    fun getProductAll(): GetProductAllUseCase
    fun getEventProducts(): GetEventProductsUseCase
    fun getSaleProducts(): GetSaleProductsUseCase
    fun orderProducts(): OrderProductsUseCase
    fun giftingOrder(): GiftingOrderUseCase
    fun getOrders(): GetOrdersUseCase
    fun payProducts(): PayProductsUseCase
    fun changeProductStatus(): ChangeProductStatusUseCase
}