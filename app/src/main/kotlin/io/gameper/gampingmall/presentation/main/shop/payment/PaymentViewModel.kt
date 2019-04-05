package io.gameper.gampingmall.presentation.main.shop.payment

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import io.gameper.gampingmall.presentation.main.shop.payment.di.PaymentScope
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import javax.inject.Inject

@PaymentScope
class PaymentViewModel @Inject constructor(
    private val interactor: PaymentInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
) : RxViewModel(rxLifeCycleActivityBinder) {

    val product = ObservableField<Product>()
    val quantity = ObservableInt(0)

    init {
        val (gift, quantity) = interactor.getGift()
        this.product.set(gift)
        this.quantity.set(quantity)
    }

    fun onPayClick() {
        interactor.onPaymentClick()
    }
}