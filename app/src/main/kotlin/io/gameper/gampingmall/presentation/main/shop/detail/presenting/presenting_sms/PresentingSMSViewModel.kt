package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms

import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.PresentingSMSScope
import javax.inject.Inject

@PresentingSMSScope
class PresentingSMSViewModel @Inject constructor(
    private val interactor: PresentingSMSInteractor,
    viewUseCase: PresentingSMSViewUseCase,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): RxViewModel(rxLifeCycleActivityBinder) {

    init {
        viewUseCase.observeEditTextContent()
            .bindRxLifeCycle()
            .subscribe {
                interactor.updatePhoneNumber(it)
            }
    }
}