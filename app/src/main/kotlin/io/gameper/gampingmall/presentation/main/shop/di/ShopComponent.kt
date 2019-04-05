package io.gameper.gampingmall.presentation.main.shop.di

import dagger.Component
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.di.MainComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.ShopInteractor
import io.gameper.gampingmall.presentation.main.shop.ShopNodeHolder
import io.gameper.gampingmall.presentation.main.shop.ShopRouter
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.main.shop.list.ShopListInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor

@ShopScope
@Component(
    dependencies = [MainComponent::class],
    modules = [(ShopModule::class)]
)
interface ShopComponent: ActivityComponent {
    fun inject(shopNodeHolder: ShopNodeHolder)

    fun mainView(): MainView

    fun interactor(): ShopInteractor
    fun router(): ShopRouter

    fun shopListListener() : ShopListInteractor.Listener
    fun shopDetailListener(): ShopDetailInteractor.Listener
    fun presentingListener() : PresentingInteractor.Listener
    fun purchaseListener() : PurchaseSelctorInteractor.Listener
    fun paySuccessListener(): PaySuccessInteractor.Listener
    fun paymentListener(): PaymentInteractor.Listener
}