package io.gameper.gampingmall.presentation.main.shop.detail.di

import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelectorNodeHolder

@Module
class ShopDetailModule {

    @Provides
    @ShopDetailScope
    fun providePurchaseSelectorNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: ShopDetailComponent
    ) : PurchaseSelectorNodeHolder {
        return PurchaseSelectorNodeHolder(inflater, mainView, component)
    }

    @Provides
    @ShopDetailScope
    fun providePresentingNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: ShopDetailComponent
    ) : PresentingNodeHolder {
        return PresentingNodeHolder(inflater, mainView, component)
    }

    @Provides
    @ShopDetailScope
    fun providePurchaseSelectorBackListener(interactor: ShopDetailInteractor): PurchaseSelctorInteractor.BackListener = interactor

    @Provides
    @ShopDetailScope
    fun providePresentingBackListener(interactor: ShopDetailInteractor): PresentingInteractor.BackListener = interactor
}