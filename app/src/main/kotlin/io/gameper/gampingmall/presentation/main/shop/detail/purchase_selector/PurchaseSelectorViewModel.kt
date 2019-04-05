package io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector

import androidx.databinding.ObservableInt
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.di.PurchaseSelectorScope
import javax.inject.Inject

@PurchaseSelectorScope
class PurchaseSelectorViewModel @Inject constructor(
    private val interactor: PurchaseSelctorInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
) : RxViewModel(rxLifeCycleActivityBinder) {

    val quantity = ObservableInt(1)

    init {
        interactor.getQuantityStream()
            .bindRxLifeCycle()
            .subscribe {
                quantity.set(it)
            }
    }

    fun onPurchaseClick() {
        interactor.orderRequest()
    }

    fun onIncreaseClick() {
        interactor.increaseQuantity()
    }

    fun onDecreaseClick() {
        interactor.decreaseQuantity()
    }
}