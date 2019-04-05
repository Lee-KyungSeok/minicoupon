package io.gameper.gampingmall.domain.baseUseCase

import io.gameper.gampingmall.domain.Schedulers
import io.reactivex.Single

abstract class UseCaseSingle<Type, Params> internal constructor(private val schedulers: Schedulers){

    internal abstract fun buildUseCaseSingle(params: Params?): Single<Type>

    fun execute(params: Params? =  null): Single<Type> =
        buildUseCaseSingle(params)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
}