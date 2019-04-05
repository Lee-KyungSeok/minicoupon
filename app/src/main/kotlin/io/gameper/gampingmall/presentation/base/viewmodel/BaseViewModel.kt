package io.gameper.gampingmall.presentation.base.viewmodel

import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

abstract class BaseViewModel {

}

abstract class RxViewModel(val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder) : BaseViewModel() {

    fun <T> Flowable<T>.bindRxLifeCycle() : Flowable<T> {
        return compose(rxLifeCycleActivityBinder.bindToLifecycle())
    }

    fun <T> Observable<T>.bindRxLifeCycle() : Observable<T> {
        return compose(rxLifeCycleActivityBinder.bindToLifecycle())
    }

    fun <T> Maybe<T>.bindRxLifeCycle() : Maybe<T> {
        return compose(rxLifeCycleActivityBinder.bindToLifecycle())
    }

    fun <T> Single<T>.bindRxLifeCycle() : Single<T> {
        return compose(rxLifeCycleActivityBinder.bindToLifecycle())
    }
}