package io.gameper.gampingmall.data.remote.product.model

import io.gameper.gampingmall.data.remote.base.Request
import java.math.BigDecimal
import java.util.*

data class OrderResponseModel(
    val request: Request,
    val id: String?,
    val message: String?,
    val data: OrderData?
)


data class OrderData(
    val orders: List<OrderRemoteModel>
//    @SerializedName("page_number") val pageNumber: Int, // 2
//    @SerializedName("total_size") val totalSize: Int   // 15
)

data class OrderRemoteModel(
    val requestId : String,
    val id : String,
    val userId : String,
    val productCode : String,
    val status : String,
    val priceCurrency : String,
    val sellingPrice : BigDecimal,
    val totalAmount : BigDecimal,
    val finishedAt: String?,
    val createdAt: String?,
    val product: ProductRemoteModel?
)

data class OrderRequestParameter(
    val email : String,
    val skuCode : String,
    val quantity : String
)

data class GiftingRequestParameter(
    val email : String,
    val skuCode : String,
    val quantity : String,
    val cellNo: String
)

data class PayRequestParameter(
    val email: String,
    val requestId: String
)