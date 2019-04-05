package io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail

import android.os.Parcelable
import io.gameper.gampingmall.domain.interactor.product.ChangeProductStatusUseCase
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.di.ReceivedDetailScope
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.reactivex.Single
import javax.inject.Inject

@ReceivedDetailScope
class ReceivedDetailInteractor @Inject constructor(
    router: ReceivedDetailRouter,
    activityState: ActivityState,
    private val changeProductStatusUseCase: ChangeProductStatusUseCase,
    private val giftWrapper: GiftWrapper,
    private val orderWrapper: OrderWrapper,
    private val listener: Listener
): BackStateInteractor<ReceivedDetailRouter>(router, activityState) {
    override fun onSaveData(): Parcelable? = null

    override fun onBackPressed(): Boolean {
        listener.onReceivedDetailCanceled()
        return true
    }

    fun getGift(): Product {
        return giftWrapper.product ?: throw RuntimeException("cannot find product")
    }

    fun useProduct() : Single<Product> {
        return changeProductStatusUseCase.execute(Triple(orderWrapper.tempEmail, "use", giftWrapper.product!!.productCode))
            .doOnSuccess { giftWrapper.product = it }

    }

    interface Listener {
        fun onReceivedDetailCanceled()
    }
}