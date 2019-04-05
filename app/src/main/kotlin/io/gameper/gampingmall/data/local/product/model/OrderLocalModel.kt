package io.gameper.gampingmall.data.local.product.model

import java.math.BigDecimal

data class OrderLocalModel (
    val requestId : String,
    val id : String,
    val userId : String,
    val productCode : String,
    val status : String,
    val priceCurrency : String,
    val sellingPrice : BigDecimal,
    val totalAmount : BigDecimal,
    val product: ProductLocalModel?
)