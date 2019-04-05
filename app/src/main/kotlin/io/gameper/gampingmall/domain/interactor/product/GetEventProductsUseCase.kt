package io.gameper.gampingmall.domain.interactor.product

import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseFlowable
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Product
import io.reactivex.Flowable

class GetEventProductsUseCase(schedulers: Schedulers, private val gateway: GiftShopGateway) :
    UseCaseFlowable<List<Product>, Void>(schedulers) {

    override fun buildUseCaseFlowable(params: Void?): Flowable<List<Product>> = gateway.getEventProducts()
}