package io.gameper.gampingmall.presentation.main.shop.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.detail.di.DaggerShopDetailComponent
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent

class ShopDetailNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ShopComponent
) : ViewNodeHolder<ShopDetailView, ShopDetailRouter>(inflater, parent, NodeName.SHOP_DETAIL) {

    override val layout: Int
        get() = R.layout.view_shop_detail

    override fun build(): ShopDetailRouter {
        val view = buildView()

        val component = DaggerShopDetailComponent.builder()
            .shopComponent(parentComponent)
            .build()

        component.inject(view)
        component.inject(this)

        attachView()

        return component.router()
    }
}