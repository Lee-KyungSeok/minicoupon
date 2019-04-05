package io.gameper.gampingmall.data.repository

import android.util.Log
import io.gameper.gampingmall.data.local.product.ProductLocalDataSource
import io.gameper.gampingmall.data.local.product.model.ProductLocalModel
import io.gameper.gampingmall.data.local.product.model.OrderLocalModel
import io.gameper.gampingmall.data.remote.product.ProductRemoteDataSource
import io.gameper.gampingmall.data.remote.product.model.ProductActionResponseModel
import io.gameper.gampingmall.data.repository.mapper.RemoteModelMapper
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.Response

class ProductRepository(
    val productLocalDataSource: ProductLocalDataSource,
    val productRemoteDataSource: ProductRemoteDataSource,
    val remoteModelMapper: RemoteModelMapper
) {
    fun getGiftAll() : Flowable<List<ProductLocalModel>> {

        val local: Flowable<List<ProductLocalModel>> = productLocalDataSource.getProductAll()

        val remote: Flowable<List<ProductLocalModel>> = productRemoteDataSource.getProductAll()
            .map { giftResponseModel ->
                //                giftResponseModel.msg?.let {
//                    Log.e("responseTest", "null 체크가 됨" + giftResponseModel.msg)
//                } ?: Log.e("responseTest", "null 이 나옴")
                giftResponseModel.data.products.map {
                    remoteModelMapper.productToLocal(it)
                }
            }
            .toFlowable()

        return Flowable.merge(local, remote)
    }

    fun getEventProducts() : Flowable<List<ProductLocalModel>> {

        val local: Flowable<List<ProductLocalModel>> = productLocalDataSource.getEventProducts()

        val remote: Flowable<List<ProductLocalModel>> = productRemoteDataSource.getEventProducts()
            .map { giftResponseModel ->
                giftResponseModel.data.products.map {
                    remoteModelMapper.productToLocal(it)
                }
            }
            .toFlowable()

        return Flowable.merge(local, remote)
    }

    fun getSaleProducts() : Flowable<List<ProductLocalModel>> {

        val local: Flowable<List<ProductLocalModel>> = productLocalDataSource.getSaleProducts()

        val remote: Flowable<List<ProductLocalModel>> = productRemoteDataSource.getSaleProducts()
            .map { giftResponseModel ->
                giftResponseModel.data.products.map {
                    remoteModelMapper.productToLocal(it)
                }
            }
            .toFlowable()

        return Flowable.merge(local, remote)
    }

    fun orderProducts(id: String, skuCode: String, quantity: String): Flowable<List<OrderLocalModel>> {

        val remote: Flowable<List<OrderLocalModel>> =
            productRemoteDataSource.orderProducts(id, skuCode, quantity)
                .map { orderResponseModel ->

                    orderResponseModel.data?.let {orderData ->
                        orderData.orders.map {
                            remoteModelMapper.orderToLocal(it)
                        }
                    } ?: throw Exception(orderResponseModel.message)
                }
                .toFlowable()

        return remote
    }

    fun giftingOrder(id: String, skuCode: String, quantity: String, cellNo: String) : Flowable<List<OrderLocalModel>> {
        val remote: Flowable<List<OrderLocalModel>> =
            productRemoteDataSource.giftingOrder(id, skuCode, quantity, cellNo)
                .map { orderResponseModel ->

                    orderResponseModel.data?.let {orderData ->
                        orderData.orders.map {
                            remoteModelMapper.orderToLocal(it)
                        }
                    } ?: throw Exception(orderResponseModel.message)
                }
                .toFlowable()

        return remote
    }

    fun getOrders(id: String, status: String?, direction: String?, page: Int?): Flowable<List<OrderLocalModel>> {

        val remote: Flowable<List<OrderLocalModel>> =
                productRemoteDataSource.getOrders(id, status, direction, page) // 디폴트 값 수정 필요 (status)
                    .map { orderResponseModel ->
                        orderResponseModel.data?.let {orderData ->
                            orderData.orders.map {
                                remoteModelMapper.orderToLocal(it)
                            }
                        } ?: throw Exception(orderResponseModel.message)
                    }.toFlowable()

        return remote
    }

    fun payProducts(id: String, requestId: String) : Flowable<okhttp3.Response> {

        val remote = productRemoteDataSource.payProducts(id, requestId)
            .map {
                Log.e("???", javaClass.simpleName)
                it.raw()
            }
            .toFlowable()

        return remote
    }

    fun changeProductStatus(id: String, action: String, productCode: String): Single<ProductLocalModel> {

        val remote: Single<ProductLocalModel> =
                productRemoteDataSource.changeProductStatus(id, action, productCode)
                    .map {
                        remoteModelMapper.productToLocal(it.data.product)
                    }

        return remote
    }
}