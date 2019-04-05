package io.gameper.gampingmall.entity

import java.math.BigDecimal

data class Order (
    val requestId : String,
    val id : String,
    val userId : String,
    val productCode : String,
    val status : String,
    val priceCurrency : String,
    val sellingPrice : BigDecimal,
    val totalAmount : BigDecimal,
    val product: Product?
)