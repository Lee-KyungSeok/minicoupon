package io.gameper.gampingmall.domain.interactor.product

import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseCompletable
import io.gameper.gampingmall.domain.exception.MissingUseCaseParameterException
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.reactivex.Completable

class PayProductsUseCase(schedulers: Schedulers, private val gateway: GiftShopGateway) : UseCaseCompletable<Pair<String, String>>(schedulers) {

    override fun buildUseCaseCompletable(params: Pair<String, String>?): Completable {

        val (id, requestId) = params ?: throw MissingUseCaseParameterException(javaClass)

        return gateway.payProducts(id, requestId)
    }
}