package io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess

import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.di.PaySuccessScope
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import javax.inject.Inject

@PaySuccessScope
class PaySuccessViewModel @Inject constructor(
    private val interactor: PaySuccessInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
) : RxViewModel(rxLifeCycleActivityBinder) {

    fun onGoPresentClick() = interactor.onGoPresentClick()
}