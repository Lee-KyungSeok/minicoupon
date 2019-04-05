package io.gameper.gampingmall.data.local.product

import io.gameper.gampingmall.data.local.product.dao.ProductDao
import io.gameper.gampingmall.data.local.product.model.ProductLocalModel
import io.reactivex.Flowable

class ProductLocalDataSource(val productDao: ProductDao) {

    fun getProductAll(): Flowable<List<ProductLocalModel>> = Flowable.fromArray(productDao.getProductAll())

    fun getEventProducts(): Flowable<List<ProductLocalModel>> = Flowable.fromArray(productDao.getEventProducts())

    fun getSaleProducts(): Flowable<List<ProductLocalModel>> = Flowable.fromArray(productDao.getSaleProducts())

}