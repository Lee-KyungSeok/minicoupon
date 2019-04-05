package io.gameper.gampingmall.domain.baseUseCase

import io.gameper.gampingmall.domain.Schedulers
import io.reactivex.Completable

abstract class UseCaseCompletable<in Params> internal constructor(private val schedulers: Schedulers) {

    internal abstract fun buildUseCaseCompletable(params: Params?): Completable

    fun execute(params: Params? = null) : Completable {
        return if (schedulers.observeOn != null) {
            buildUseCaseCompletable(params)
                .subscribeOn(schedulers.subscribeOn)
                .observeOn(schedulers.observeOn)
        } else {
            buildUseCaseCompletable(params)
                .subscribeOn(schedulers.subscribeOn)

        }
    }
}