package io.gameper.gampingmall.presentation.main.shop.detail

import androidx.databinding.ObservableField
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailScope
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import javax.inject.Inject

@ShopDetailScope
class ShopDetailViewModel @Inject constructor(
    private val interactor: ShopDetailInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): RxViewModel(rxLifeCycleActivityBinder) {

    val product = ObservableField<Product>()

    init {
        product.set(interactor.getGift())
    }

    fun onPurchaseClick() {
        interactor.selectPurchase()
    }

    fun onPresentClick() {
        interactor.selectPresenting()
    }
}