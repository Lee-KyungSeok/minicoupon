package io.gameper.gampingmall.presentation.main.shop.detail.di

import dagger.Component
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailRouter
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailView
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor

@ShopDetailScope
@Component(
    dependencies = [ShopComponent::class],
    modules = [ShopDetailModule::class]
)
interface ShopDetailComponent : ActivityComponent {

    fun inject(shopDetailView: ShopDetailView)
    fun inject(shopDetailNodeHolder: ShopDetailNodeHolder)

    fun mainView(): MainView
    fun interactor(): ShopDetailInteractor
    fun router(): ShopDetailRouter

    fun purchaseListener() : PurchaseSelctorInteractor.Listener
    fun purchaseBackListener(): PurchaseSelctorInteractor.BackListener
    fun presentingListener() : PresentingInteractor.Listener
    fun presentingBackListener(): PresentingInteractor.BackListener
}