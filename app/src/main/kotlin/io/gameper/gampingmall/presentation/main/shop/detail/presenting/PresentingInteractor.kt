package io.gameper.gampingmall.presentation.main.shop.detail.presenting

import android.os.Parcelable
import android.util.Log
import io.gameper.gampingmall.domain.interactor.product.GiftingOrderUseCase
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingScope
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.gameper.gampingmall.utils.Quadruple
import io.gameper.gampingmall.utils.isPhone
import javax.inject.Inject

@PresentingScope
class PresentingInteractor @Inject constructor(
    router: PresentingRouter,
    activityState: ActivityState,
    private val giftingOrderUseCase: GiftingOrderUseCase,
    private val giftWrapper: GiftWrapper,
    private val orderWrapper: OrderWrapper,
    private val listener: PresentingInteractor.Listener,
    private val backListener: PresentingInteractor.BackListener,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): BackStateInteractor<PresentingRouter>(router, activityState) {
    override fun onSaveData(): Parcelable? = null

    override fun onBackPressed(): Boolean {
        backListener.onPresentingCanceled()
        return true
    }

    fun getGift(): Product {
        giftWrapper.quantity = 1
        return giftWrapper.product ?: throw RuntimeException("cannot find product")
    }

    fun presentingRequest() {
        if(giftWrapper.quantity > 0) {
            when (orderWrapper.type) {
                "SMS" -> {
                    if(!orderWrapper.cellNo.isPhone()) return
                    giftingOrderUseCase.execute(Quadruple(orderWrapper.tempEmail, giftWrapper.product!!.skuCode, giftWrapper.quantity.toString(), orderWrapper.cellNo))
                        .compose(rxLifeCycleActivityBinder.bindToLifecycle())
                        .doOnComplete { listener.changeToPaymentByPresenting() }
                        .subscribe { orderList ->
                            orderWrapper.orders = orderList
                        }
                }
                "KAKAO" -> {

                }
            }
        }
    }

    fun showSMSPresentingView() {
        router.attachPresentingSMS()
    }

    interface Listener {
        fun changeToPaymentByPresenting()
    }

    interface BackListener {
        fun onPresentingCanceled()
    }
}