package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms

import android.util.Log
import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.PresentingSMSScope
import io.gameper.gampingmall.presentation.model.OrderWrapper
import javax.inject.Inject

@PresentingSMSScope
class PresentingSMSInteractor @Inject constructor(
    router: PresentingSMSRouter,
    activityState: ActivityState,
    private val orderWrapper: OrderWrapper
): BaseInteractor<PresentingSMSRouter>(router, activityState) {

    fun updatePhoneNumber(phone: String) {
        orderWrapper.cellNo = phone
    }
}