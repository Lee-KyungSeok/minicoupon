package io.gameper.gampingmall.data.local.product.dao

import io.gameper.gampingmall.data.local.product.model.ProductLocalModel

class ProductDao {

    // ToDo 나중에 캐싱 작업 시에 사용할 것
    fun getProductAll(): List<ProductLocalModel> {
        val productListModel : List<ProductLocalModel> = mutableListOf()

        return productListModel
    }

    fun getEventProducts(): List<ProductLocalModel> {
        val productListModel : List<ProductLocalModel> = mutableListOf()

        return productListModel
    }

    fun getSaleProducts(): List<ProductLocalModel> {
        val productListModel : List<ProductLocalModel> = mutableListOf()

        return productListModel
    }
}