package io.gameper.gampingmall.data.gateway

import android.util.Log
import io.gameper.gampingmall.data.gateway.mapper.EntityModelMapper
import io.gameper.gampingmall.data.repository.ProductRepository
import io.gameper.gampingmall.data.repository.TradeRepository
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Order
import io.gameper.gampingmall.entity.Product
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class GiftShopGatewayImpl(
    val productRepository: ProductRepository,
    val tradeRepository: TradeRepository,
    val entityModelMapper: EntityModelMapper
) : GiftShopGateway {

    // Todo Error 처리 필요함!

    override fun getProductAll(): Flowable<List<Product>> {
        return productRepository.getGiftAll()
            .map {gitLocalModelList ->
                gitLocalModelList.map {
                    entityModelMapper.productToEntity(it)
                }
            }
    }

    override fun getEventProducts(): Flowable<List<Product>> {
        return productRepository.getEventProducts()
            .map {gitLocalModelList ->
                gitLocalModelList.map {
                    entityModelMapper.productToEntity(it)
                }
            }    }

    override fun getSaleProducts(): Flowable<List<Product>> {
        return productRepository.getSaleProducts()
            .map {gitLocalModelList ->
                gitLocalModelList.map {
                    entityModelMapper.productToEntity(it)
                }
            }    }

    override fun orderProducts(id: String, skuCode: String, quantity: String): Flowable<List<Order>> {
        return productRepository.orderProducts(id, skuCode, quantity)
            .map {orderLocalModelList ->
                orderLocalModelList.map {
                    entityModelMapper.orderToEntity(it)
                }
            }
    }

    override fun giftingOrder(id: String, skuCode: String, quantity: String, cellNo: String): Flowable<List<Order>> {
        return productRepository.giftingOrder(id, skuCode, quantity, cellNo)
            .map {orderLocalModelList ->
                orderLocalModelList.map {
                    entityModelMapper.orderToEntity(it)
                }
            }
    }

    override fun getOrders(id:String, status: String?, direction: String?, page: Int?): Flowable<List<Order>> {
        // Todo page 는 나중에 처리한다.
        return productRepository.getOrders(id, status, direction, page)
            .map {orderLocalModelList ->
                orderLocalModelList.map {
                    entityModelMapper.orderToEntity(it)
                }
            }
    }

    override fun payProducts(id: String, requestId: String): Completable {
        return productRepository.payProducts(id, requestId)
            .map {
                Log.e("GiftShopGatewayImpl", requestId)
                it
            }
            .concatMapCompletable {
                Log.e("complete", it.code().toString())
                if (it.isSuccessful) Completable.complete()
                else Completable.error(Exception("payment is failed"))
            }
    }

    override fun changeProductStatus(id: String, action: String, productCode: String): Single<Product> {
        return productRepository.changeProductStatus(id, action, productCode)
            .map {
                entityModelMapper.productToEntity(it)
            }
    }
}