package io.gameper.gampingmall.presentation.main.shop

import android.os.Parcelable
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.StateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.di.ShopScope
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.main.shop.list.ShopListInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentInteractor
import javax.inject.Inject

@ShopScope
class ShopInteractor @Inject constructor(
    router: ShopRouter,
    activityState: ActivityState,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder,
    private val listener: Listener
) : StateInteractor<ShopRouter>(router, activityState),
    ShopListInteractor.Listener,
    ShopDetailInteractor.Listener,
    PresentingInteractor.Listener,
    PurchaseSelctorInteractor.Listener,
    PaymentInteractor.Listener {

    override fun onSaveData(): Parcelable? {
        return null
    }

    override fun restoreState() {
        super.restoreState()
        if(!hasSavedState()) {
            router.startShopList()
        }
    }

    override fun onGiftSelected() {
        listener.onBottomGoneByShop()
        router.startShopDetail()
    }

    override fun onShopDetailCanceled() {
        listener.onBottomVisibleByShop()
        router.startShopList()
    }

    override fun changeToPaymentByPresenting() {
        router.startPayment()
    }

    override fun changeToPaymentByPurchase() {
        router.startPayment()
    }

    override fun onPaymentCanceled() {
        router.startShopDetail()
    }

    interface Listener {
        fun onBottomGoneByShop()
        fun onBottomVisibleByShop()
    }

}