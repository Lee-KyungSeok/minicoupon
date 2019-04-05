package io.gameper.gampingmall.presentation.main.shop.list.di

import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.shop.list.ShopListAdapter
import io.gameper.gampingmall.presentation.main.shop.list.ShopListInteractor

@Module
class ShopListModule {

    @ShopListScope
    @Provides
    fun providesShopListAdapter(interactor: ShopListInteractor): ShopListAdapter = ShopListAdapter(interactor)

//    @ShopListScope
//    @Provides
//    internal fun providesView(): ShopListView {
//        return view
//    }
}