package io.gameper.gampingmall.domain.interactor.product

import android.util.Log
import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseFlowable
import io.gameper.gampingmall.domain.exception.MissingUseCaseParameterException
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Order
import io.gameper.gampingmall.utils.Quadruple
import io.reactivex.Flowable

class GetOrdersUseCase(schedulers: Schedulers, private val gateway: GiftShopGateway) : UseCaseFlowable<List<Order>, Quadruple<String, String?, String?, Int?>>(schedulers) {

    override fun buildUseCaseFlowable(params: Quadruple<String, String?, String?, Int?>?): Flowable<List<Order>> {
        val (id, status, direction, page) = params ?: throw MissingUseCaseParameterException(javaClass)
        return gateway.getOrders(id, status, direction, page)
    }
}