package io.gameper.gampingmall.data.remote.product.api

import io.gameper.gampingmall.data.remote.product.model.*
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ProductApi {

    @GET("shop/api/v1/products")
    fun getProducts(): Single<ProductResponseModel>

    @GET("shop/api/v1/event_products")
    fun getEventProducts(): Single<ProductResponseModel>

    @GET("shop/api/v1/sale_products")
    fun getSaleProducts(): Single<ProductResponseModel>

    @POST("shop/api/v1/order")
    fun orderProducts(
        @Body orderRequestParameter: OrderRequestParameter
    ): Single<OrderResponseModel>

    @POST("shop/api/v1/gifting_order")
    fun giftingOrder(
        @Body giftingRequestParameter: GiftingRequestParameter
    ): Single<OrderResponseModel>

    @GET("shop/api/v1/orders")
    fun getOrders(
        @Query("email") email: String,
        @Query("status") status: String?,
        @Query("direction") direction: String?,
        @Query("page") page: Int?,
        @Query("size") size: Int?
    ) : Single<OrderResponseModel>

    @POST("shop/api/v1/pay")
    fun payProducts(
        @Body payRequestParameter: PayRequestParameter
    ) : Single<Response<OrderResponseModel>>

    @POST("shop/api/v1/action")
    fun changeProductStatus(
        @Body productActionRequestParameter: ProductActionRequestParameter
    ): Single<ProductActionResponseModel>
}