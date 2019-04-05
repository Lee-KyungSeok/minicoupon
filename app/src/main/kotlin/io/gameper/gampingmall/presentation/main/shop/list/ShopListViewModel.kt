package io.gameper.gampingmall.presentation.main.shop.list

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import io.gameper.gampingmall.presentation.main.shop.list.di.ShopListScope
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.viewmodel.RxViewModel
import javax.inject.Inject

@ShopListScope
class ShopListViewModel @Inject constructor(
    val interactor: ShopListInteractor,
    rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): RxViewModel(rxLifeCycleActivityBinder) {

    val saleGift = ObservableField<Product>()
    val shopGiftList = ObservableArrayList<Product>()

    init {
        interactor.requestSaleProducts()
            .bindRxLifeCycle()
            .filter { !it.isEmpty() }
            .subscribe{
                saleGift.set(it[0])
            }

        interactor.requestEventProducts()
            .bindRxLifeCycle()
            .filter { !it.isEmpty() }
            .subscribe{
                shopGiftList.clear()
                shopGiftList.addAll(it)
            }
    }

    fun onClick(product: Product) {
        interactor.changeToDetail(product)
    }
}