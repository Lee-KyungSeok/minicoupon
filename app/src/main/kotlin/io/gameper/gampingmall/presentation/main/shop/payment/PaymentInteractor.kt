package io.gameper.gampingmall.presentation.main.shop.payment

import android.os.Parcelable
import android.util.Log
import io.gameper.gampingmall.domain.interactor.product.PayProductsUseCase
import io.gameper.gampingmall.entity.Order
import io.gameper.gampingmall.presentation.main.shop.payment.di.PaymentScope
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BackStateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessNodeHolder
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import java.lang.RuntimeException
import javax.inject.Inject

@PaymentScope
class PaymentInteractor @Inject constructor(
    router: PaymentRouter,
    activityState: ActivityState,
    private val giftWrapper: GiftWrapper,
    private val orderWrapper: OrderWrapper,
    private val payProductsUseCase: PayProductsUseCase,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder,
    private val listener: Listener
) : BackStateInteractor<PaymentRouter>(router, activityState) {
    override fun onSaveData(): Parcelable? = null

    override fun onBackPressed(): Boolean {
        listener.onPaymentCanceled()
        return true
    }

    fun getGift(): Pair<Product, Int> {
        val gift = giftWrapper.product ?: throw RuntimeException("cannot find product")
        val quantity = giftWrapper.quantity;
        return Pair(gift, quantity)
    }

    fun onPaymentClick() {
        payProductsUseCase.execute(Pair(orderWrapper.tempEmail, orderWrapper.orders[0].requestId))
            .compose(rxLifeCycleActivityBinder.bindToLifecycle<Void>())
            .subscribe({
                router.attachPaySuccess()
            }, {
                it.printStackTrace()
            })
    }

    interface Listener {
        fun onPaymentCanceled()
    }

}