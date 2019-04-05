package io.gameper.gampingmall.presentation.model

import io.gameper.gampingmall.entity.Order

data class OrderWrapper (
    var orders: List<Order> = mutableListOf(),
    var tempEmail: String = "",
    var type: String = "SMS",
    var cellNo: String = ""
)