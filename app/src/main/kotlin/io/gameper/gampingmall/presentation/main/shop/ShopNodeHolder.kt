package io.gameper.gampingmall.presentation.main.shop

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.di.MainComponent
import io.gameper.gampingmall.presentation.main.shop.di.DaggerShopComponent
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent

class ShopNodeHolder(
    private val parentComponent: MainComponent
) : BaseNodeHolder<ShopRouter>(NodeName.SHOP) {

    override fun build(): ShopRouter {
        val component =  DaggerShopComponent.builder()
            .mainComponent(parentComponent)
            .build()
        component.inject(this)

        component.interactor().restoreState()
        return component.router()
    }
}