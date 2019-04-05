package io.gameper.gampingmall.domain.baseUseCase

import io.gameper.gampingmall.domain.Schedulers
import io.reactivex.Maybe

abstract class UseCaseMaybe<Type, Params> internal constructor(private val schedulers: Schedulers){

    internal abstract fun buildUseCaseMaybe(params: Params?): Maybe<Type>

    fun execute(params: Params? =  null): Maybe<Type> =
            buildUseCaseMaybe(params)
                .subscribeOn(schedulers.subscribeOn)
                .observeOn(schedulers.observeOn)
}