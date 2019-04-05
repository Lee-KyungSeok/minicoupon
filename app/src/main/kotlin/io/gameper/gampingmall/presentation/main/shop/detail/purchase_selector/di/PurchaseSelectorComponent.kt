package io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.di

import dagger.Component
import dagger.Module
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailComponent
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelctorInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelectorNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelectorRouter

@PurchaseSelectorScope
@Component(
    dependencies = [ShopDetailComponent::class],
    modules = [PurchaseSelectorComponent.PurChaseSelectorModule::class]
)
interface PurchaseSelectorComponent : ActivityComponent {

    fun inject(purchaseSelectorNodeHolder: PurchaseSelectorNodeHolder)
    fun interactor(): PurchaseSelctorInteractor
    fun router(): PurchaseSelectorRouter

    @Module
    class PurChaseSelectorModule {

    }
}