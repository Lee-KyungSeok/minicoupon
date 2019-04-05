package io.gameper.gampingmall.presentation.main.shop.detail.presenting

import androidx.databinding.ObservableField
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingScope
import javax.inject.Inject

@PresentingScope
class PresentingViewModel @Inject constructor(
    private val interactor: PresentingInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
) : RxViewModel(rxLifeCycleActivityBinder) {

    val product = ObservableField<Product>()

    init {
        product.set(interactor.getGift())
        interactor.showSMSPresentingView()
    }

    fun onNextClick() {
        try {
            interactor.presentingRequest()
        } catch (e: Exception) {

        }
    }

    fun onCancelClick() {
        interactor.onBackPressed()
    }

    fun onKakaoClick() {

    }

    fun onSMSClick() {
        interactor.showSMSPresentingView()
    }
}