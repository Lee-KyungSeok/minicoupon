package io.gameper.gampingmall.domain.interactor.product

import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseFlowable
import io.gameper.gampingmall.domain.exception.MissingUseCaseParameterException
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Order
import io.gameper.gampingmall.utils.Quadruple
import io.reactivex.Flowable

class GiftingOrderUseCase(schedulers: Schedulers, private val gateway: GiftShopGateway):
    UseCaseFlowable<List<Order>, Quadruple<String, String, String, String>>(schedulers) {

    override fun buildUseCaseFlowable(params: Quadruple<String, String, String, String>?): Flowable<List<Order>> {
        val (id, skuCode, quantity, cellNo) = params ?: throw MissingUseCaseParameterException(javaClass)

        return gateway.giftingOrder(id, skuCode, quantity, cellNo)
    }
}