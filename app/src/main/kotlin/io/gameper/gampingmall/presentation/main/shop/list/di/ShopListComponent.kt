package io.gameper.gampingmall.presentation.main.shop.list.di

import dagger.Component
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.list.ShopListNodeHolder
import io.gameper.gampingmall.presentation.main.shop.list.ShopListView
import io.gameper.gampingmall.presentation.main.shop.list.ShopListInteractor
import io.gameper.gampingmall.presentation.main.shop.list.ShopListRouter

@ShopListScope
@Component(
    dependencies = [ShopComponent::class],
    modules = [(ShopListModule::class)]
)
interface ShopListComponent : ActivityComponent {

    fun inject(shopListView: ShopListView)
    fun inject(shopListNodeHolder: ShopListNodeHolder)

    fun mainView(): MainView
    fun interactor(): ShopListInteractor
    fun router(): ShopListRouter
}