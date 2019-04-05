package io.gameper.gampingmall.data.remote.product

import io.gameper.gampingmall.data.remote.product.api.ProductApi
import io.gameper.gampingmall.data.remote.product.model.*
import io.reactivex.Single
import retrofit2.Response

class ProductRemoteDataSource(val productApi: ProductApi) {

    // Todo network 에러 처리 필요함 (handler 만들어서 처리할 것)
    fun getProductAll(): Single<ProductResponseModel> = productApi.getProducts()

    fun getEventProducts(): Single<ProductResponseModel> = productApi.getEventProducts()

    fun getSaleProducts(): Single<ProductResponseModel> = productApi.getSaleProducts()

    fun orderProducts(id: String, skuCode: String, quantity: String): Single<OrderResponseModel> = productApi.orderProducts(
        OrderRequestParameter(id, skuCode, quantity)
    )

    fun giftingOrder(id: String, skuCode: String, quantity: String, cellNo: String): Single<OrderResponseModel> = productApi.giftingOrder(
        GiftingRequestParameter(id, skuCode, quantity, cellNo)
    )

    fun getOrders(id: String, status: String?, direction:String?, page: Int?): Single<OrderResponseModel> = productApi.getOrders(id, status, direction ,page, 20)

    fun payProducts(id: String, requestId: String): Single<Response<OrderResponseModel>> = productApi.payProducts(
        PayRequestParameter(id, requestId)
    )

    fun changeProductStatus(id: String, action: String, productCode: String): Single<ProductActionResponseModel> = productApi.changeProductStatus(
        ProductActionRequestParameter(id, action, productCode)
    )
}