package io.gameper.gampingmall.data.gateway.mapper

import io.gameper.gampingmall.data.local.product.model.ProductLocalModel
import io.gameper.gampingmall.data.local.product.model.OrderLocalModel
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.entity.Order
import java.math.BigDecimal

class EntityModelMapper {

    fun productToEntity(productLocalModel: ProductLocalModel): Product =
        Product(productLocalModel.skuCode, productLocalModel.productCode, productLocalModel.productName, productLocalModel.productType, productLocalModel.status,
            productLocalModel.brandName, productLocalModel.description, productLocalModel.discountRate, productLocalModel.giftVendor, productLocalModel.imageUrl,
            productLocalModel.price.setScale(0, BigDecimal.ROUND_CEILING), productLocalModel.sellingPrice.setScale(0, BigDecimal.ROUND_CEILING),
            productLocalModel.priceCurrency, productLocalModel.priceSymbol, productLocalModel.priceSymbolKo, productLocalModel.expiredAt)

    fun orderToEntity(orderLocalModel: OrderLocalModel) =
        Order(
            orderLocalModel.requestId,
            orderLocalModel.id,
            orderLocalModel.userId,
            orderLocalModel.productCode,
            orderLocalModel.status,
            orderLocalModel.priceCurrency,
            orderLocalModel.sellingPrice,
            orderLocalModel.totalAmount,
            orderLocalModel.product?.let { productToEntity(it) }
        )
}