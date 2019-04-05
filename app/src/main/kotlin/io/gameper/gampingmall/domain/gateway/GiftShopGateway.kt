package io.gameper.gampingmall.domain.gateway

import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.entity.Order
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface GiftShopGateway {
    fun getProductAll(): Flowable<List<Product>>
    fun getEventProducts(): Flowable<List<Product>>
    fun getSaleProducts(): Flowable<List<Product>>
    fun orderProducts(id: String, skuCode: String, quantity: String): Flowable<List<Order>>
    fun giftingOrder(id: String, skuCode: String, quantity: String, cellNo: String): Flowable<List<Order>>
    fun getOrders(id:String, status: String?, direction: String?, page: Int?): Flowable<List<Order>>
    fun payProducts(id: String, requestId: String): Completable
    fun changeProductStatus(id: String, action: String, productCode: String): Single<Product>
}