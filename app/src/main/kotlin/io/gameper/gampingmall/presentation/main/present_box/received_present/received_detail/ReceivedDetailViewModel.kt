package io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail

import androidx.databinding.ObservableField
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.di.ReceivedDetailScope
import io.gameper.gampingmall.utils.ToastProvider
import javax.inject.Inject
import javax.inject.Named

@ReceivedDetailScope
class ReceivedDetailViewModel @Inject constructor(
    private val interactor: ReceivedDetailInteractor,
    @Named("activityToast") private val toastProvider: ToastProvider,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): RxViewModel(rxLifeCycleActivityBinder) {

    val product = ObservableField<Product>()

    init {
        product.set(interactor.getGift())
        if (interactor.hasSavedState()) interactor.restoreState()
    }

    fun onBarcodeClick() {
        if(product.get()!!.status != "used") {
            interactor.useProduct()
                .bindRxLifeCycle()
                .subscribe { productComplete ->
                    toastProvider.makeToast("$product.productName 이 사용되었습니다.")
                    product.set(productComplete)
                }
        } else {
            toastProvider.makeToast("이미 사용된 상품입니다.")
        }
    }

}