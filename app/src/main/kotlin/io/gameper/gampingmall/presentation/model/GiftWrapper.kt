package io.gameper.gampingmall.presentation.model

import io.gameper.gampingmall.entity.Product

data class GiftWrapper(
    var product: Product?,
    var quantity: Int = 1
)