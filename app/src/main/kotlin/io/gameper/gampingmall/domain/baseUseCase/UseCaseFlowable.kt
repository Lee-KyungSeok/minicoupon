package io.gameper.gampingmall.domain.baseUseCase

import io.gameper.gampingmall.domain.Schedulers
import io.reactivex.Flowable

abstract class UseCaseFlowable<Type, in Params> internal constructor(private val schedulers: Schedulers){

    internal abstract fun buildUseCaseFlowable(params: Params?): Flowable<Type>

    fun execute(params: Params? = null) : Flowable<Type> =
            buildUseCaseFlowable(params)
                .subscribeOn(schedulers.subscribeOn)
                .observeOn(schedulers.observeOn)
}