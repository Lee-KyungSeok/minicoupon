package io.gameper.gampingmall.domain.interactor.product

import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.domain.baseUseCase.UseCaseSingle
import io.gameper.gampingmall.domain.exception.MissingUseCaseParameterException
import io.gameper.gampingmall.domain.gateway.GiftShopGateway
import io.gameper.gampingmall.entity.Product
import io.reactivex.Single

class ChangeProductStatusUseCase(schedulers: Schedulers, private val gateway: GiftShopGateway): UseCaseSingle<Product, Triple<String, String, String>>(schedulers) {

    override fun buildUseCaseSingle(params: Triple<String, String, String>?): Single<Product> {
        val (id, action, productCode) = params ?: throw MissingUseCaseParameterException(javaClass)

        return gateway.changeProductStatus(id, action, productCode)
    }
}