package io.gameper.gampingmall.domain.interactor.product

import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseFlowable
import io.gameper.gampingmall.domain.exception.MissingUseCaseParameterException
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Order
import io.reactivex.Flowable

class OrderProductsUseCase(schedulers: Schedulers, val gateway: GiftShopGateway) : UseCaseFlowable<List<Order>, Triple<String, String, String>>(schedulers){

    override fun buildUseCaseFlowable(params: Triple<String, String, String>?): Flowable<List<Order>> {
        val (id, skuCode, quantity) = params ?: throw MissingUseCaseParameterException(javaClass)

        return gateway.orderProducts(id, skuCode, quantity)
    }
}