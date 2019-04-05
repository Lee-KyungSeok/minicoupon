package io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector

import android.os.Parcelable
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.di.PurchaseSelectorScope
import io.gameper.gampingmall.domain.interactor.product.OrderProductsUseCase
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

@PurchaseSelectorScope
class PurchaseSelctorInteractor @Inject constructor(
    router: PurchaseSelectorRouter,
    activityState: ActivityState,
    val giftWrapper: GiftWrapper,
    val orderWrapper: OrderWrapper,
    val orderProductsUseCase: OrderProductsUseCase,
    val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder,
    val listener: Listener,
    val backListener: BackListener
): BackStateInteractor<PurchaseSelectorRouter>(router, activityState) {

    override fun onSaveData(): Parcelable?  = null

    val quantity = BehaviorSubject.createDefault(giftWrapper.quantity)

    fun orderRequest() {
        if(giftWrapper.quantity > 0) {
            orderProductsUseCase.execute(Triple(orderWrapper.tempEmail, giftWrapper.product!!.skuCode, giftWrapper.quantity.toString()))
                .compose(rxLifeCycleActivityBinder.bindToLifecycle())
                .doOnComplete { listener.changeToPaymentByPurchase() }
                .subscribe{orderList ->
                    orderWrapper.orders = orderList
                }
        }
    }

    fun getQuantityStream(): Observable<Int> {
        return quantity.distinctUntilChanged()
    }

    fun increaseQuantity() {
        if(giftWrapper.quantity < 3) {
            giftWrapper.quantity = giftWrapper.quantity + 1
            quantity.onNext(giftWrapper.quantity)
        }
    }

    fun decreaseQuantity() {
        if(giftWrapper.quantity > 1) {
            giftWrapper.quantity = giftWrapper.quantity - 1
            quantity.onNext(giftWrapper.quantity)
        }
    }

    override fun onBackPressed(): Boolean {
        backListener.onPurchaseSelectionCanceled()
        return true
    }

    interface Listener {
        fun changeToPaymentByPurchase()
    }

    interface BackListener {
        fun onPurchaseSelectionCanceled()
    }
}