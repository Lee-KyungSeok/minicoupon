package io.gameper.gampingmall.presentation.main.shop.list

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent
import io.gameper.gampingmall.presentation.main.shop.list.di.DaggerShopListComponent

class ShopListNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ShopComponent
) : ViewNodeHolder<ShopListView, ShopListRouter>(inflater, parent, NodeName.SHOP_LIST) {

    override val layout: Int
        get() = R.layout.view_shop_list

    override fun build(): ShopListRouter {
        val view = buildView()

        val component =  DaggerShopListComponent.builder()
            .shopComponent(parentComponent)
            .build()
        component.inject(view)
        component.inject(this)

        attachView()
        return component.router()
    }
}