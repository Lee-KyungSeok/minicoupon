package io.gameper.gampingmall.presentation.main.shop.list

import io.gameper.gampingmall.domain.interactor.product.GetEventProductsUseCase
import io.gameper.gampingmall.domain.interactor.product.GetProductAllUseCase
import io.gameper.gampingmall.domain.interactor.product.GetSaleProductsUseCase
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.shop.list.di.ShopListScope
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.reactivex.Flowable
import io.reactivex.internal.operators.flowable.FlowableAll
import javax.inject.Inject

@ShopListScope
class ShopListInteractor @Inject constructor(
    router: ShopListRouter,
    activityState: ActivityState,
    private val giftWrapper: GiftWrapper,
    private val getProductAllUseCase: GetProductAllUseCase,
    private val getEventProductsUseCase: GetEventProductsUseCase,
    private val getSaleProductsUseCase: GetSaleProductsUseCase,
    private val listener: ShopListInteractor.Listener,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): BaseInteractor<ShopListRouter>(router, activityState) {

    fun requestProductAll(): Flowable<List<Product>> {
        return getProductAllUseCase.execute()
    }

    fun requestEventProducts() : Flowable<List<Product>> {
        return getEventProductsUseCase.execute()
    }

    fun requestSaleProducts() : Flowable<List<Product>> {
        return getSaleProductsUseCase.execute()
    }

    fun changeToDetail(product: Product) {
        giftWrapper.product = product
        giftWrapper.product.let {
            listener.onGiftSelected()
        }
    }

    interface Listener {
        fun onGiftSelected()
    }
}