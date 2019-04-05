package io.gameper.gampingmall.data.repository.mapper

import io.gameper.gampingmall.data.local.product.model.ProductLocalModel
import io.gameper.gampingmall.data.local.product.model.OrderLocalModel
import io.gameper.gampingmall.data.remote.product.model.ProductRemoteModel
import io.gameper.gampingmall.data.remote.product.model.OrderRemoteModel

class RemoteModelMapper {

    fun productToLocal(productRemoteModel: ProductRemoteModel): ProductLocalModel =
        ProductLocalModel(productRemoteModel.skuCode, productRemoteModel.productCode, productRemoteModel.productName, productRemoteModel.productType, productRemoteModel.status,
            productRemoteModel.brandName, productRemoteModel.description, productRemoteModel.discountRate, productRemoteModel.giftVendor,
            productRemoteModel.imageUrl, productRemoteModel.price, productRemoteModel.sellingPrice, productRemoteModel.priceCurrency,
            productRemoteModel.priceSymbol, productRemoteModel.priceSymbolKo, productRemoteModel.expiredAt)

    fun orderToLocal(orderRemoteModel: OrderRemoteModel) =
        OrderLocalModel(
            orderRemoteModel.requestId,
            orderRemoteModel.id,
            orderRemoteModel.userId,
            orderRemoteModel.productCode,
            orderRemoteModel.status,
            orderRemoteModel.priceCurrency,
            orderRemoteModel.sellingPrice,
            orderRemoteModel.totalAmount,
            orderRemoteModel.product?.let {
                productToLocal(it)
            }
        )
}