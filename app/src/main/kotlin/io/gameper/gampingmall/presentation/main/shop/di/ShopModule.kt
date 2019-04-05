package io.gameper.gampingmall.presentation.main.shop.di

import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.ShopInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.main.shop.list.ShopListInteractor
import io.gameper.gampingmall.presentation.main.shop.list.ShopListNodeHolder
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentNodeHolder

@Module
class ShopModule {

    @ShopScope
    @Provides
    fun provideShopListNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: ShopComponent
    ) : ShopListNodeHolder =
        ShopListNodeHolder(inflater, mainView, component)

    @ShopScope
    @Provides
    fun provideShopDetailNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: ShopComponent
    ) : ShopDetailNodeHolder = ShopDetailNodeHolder(inflater, mainView, component)

    @ShopScope
    @Provides
    fun providePaymentlNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: ShopComponent
    ) : PaymentNodeHolder = PaymentNodeHolder(inflater, mainView, component)

    @ShopScope
    @Provides
    fun provideShopListListener(interactor: ShopInteractor): ShopListInteractor.Listener = interactor

    @ShopScope
    @Provides
    fun provideShopDetailListener(interactor: ShopInteractor): ShopDetailInteractor.Listener = interactor

    @ShopScope
    @Provides
    fun providePresentingListener(interactor: ShopInteractor): PresentingInteractor.Listener = interactor

    @ShopScope
    @Provides
    fun providePurchaseSelectorListener(interactor: ShopInteractor): PurchaseSelctorInteractor.Listener = interactor

    @ShopScope
    @Provides
    fun providePaymentListener(interactor: ShopInteractor): PaymentInteractor.Listener = interactor
}