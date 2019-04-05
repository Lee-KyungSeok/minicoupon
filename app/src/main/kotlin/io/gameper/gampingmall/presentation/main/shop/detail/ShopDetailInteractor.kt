package io.gameper.gampingmall.presentation.main.shop.detail

import android.os.Parcelable
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailScope
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.model.GiftWrapper
import java.lang.RuntimeException
import javax.inject.Inject

@ShopDetailScope
class ShopDetailInteractor @Inject constructor(
    router: ShopDetailRouter,
    activityState: ActivityState,
    private val giftWrapper: GiftWrapper,
    private val listener: Listener
): BackStateInteractor<ShopDetailRouter>(router, activityState), PurchaseSelctorInteractor.BackListener, PresentingInteractor.BackListener {
    override fun onSaveData(): Parcelable? = null

    override fun onBackPressed(): Boolean {
        listener.onShopDetailCanceled()
        return true
    }

    fun getGift(): Product {
        return giftWrapper.product ?: throw RuntimeException("cannot find product")
    }

    fun selectPurchase() {
        router.attachPurchaseSelector()
    }

    fun selectPresenting() {
        router.attachPresenting()
    }

    override fun onPurchaseSelectionCanceled() {
        router.detachPurchaseSelector()
    }

    override fun onPresentingCanceled() {
        router.detachPresenting()
    }

    interface Listener {
        fun onShopDetailCanceled()
    }
}