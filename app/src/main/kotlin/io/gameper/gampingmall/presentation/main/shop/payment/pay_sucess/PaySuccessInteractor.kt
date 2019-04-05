package io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess

import android.os.Parcelable
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.di.PaySuccessScope
import javax.inject.Inject

@PaySuccessScope
class PaySuccessInteractor @Inject constructor(
    router: PaySuccessRouter,
    activityState: ActivityState,
    private val listener: Listener
): BackStateInteractor<PaySuccessRouter>(router, activityState) {
    override fun onSaveData(): Parcelable?  = null

    override fun onBackPressed(): Boolean {
        listener.onBackSuccessClick()
        return true
    }

    fun onGoPresentClick() = listener.onGoPresentClick()

    interface Listener {
        fun onGoPresentClick()
        fun onBackSuccessClick()
    }
}
