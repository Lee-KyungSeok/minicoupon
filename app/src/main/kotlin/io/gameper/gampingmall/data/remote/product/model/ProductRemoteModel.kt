package io.gameper.gampingmall.data.remote.product.model

import io.gameper.gampingmall.data.remote.base.Request
import java.math.BigDecimal
import java.util.*

data class ProductResponseModel(
    val request: Request,
    val data: ProductData
)

data class ProductData(
    val products: List<ProductRemoteModel>
//    @SerializedName("page_number") val pageNumber: Int, // 2
//    @SerializedName("total_size") val totalSize: Int   // 15
)

data class ProductRemoteModel(
    val skuCode: String,
    val productCode: String,
    val productName: String,
    val productType: String,
    val status: String,
    val brandName: String,
    val description: String,
    val discountRate: Float,
    val giftVendor: String,
    val imageUrl: String,
    val price: BigDecimal,
    val sellingPrice: BigDecimal,
    val priceCurrency: String,
    val priceSymbol: String,
    val priceSymbolKo: String,
    val reservedAt: Date,
    val expiredAt: Date,
    val createdAt: Date,
    val updatedAt: Date,
    val payable: Boolean,
    val orderable: Boolean
)

data class ProductActionResponseModel(
    val request: Request,
    val data: ProductActionData
)

data class ProductActionData(
    val product: ProductRemoteModel
)

data class ProductActionRequestParameter(
    val email : String,
    val action: String,
    val productCode: String
)