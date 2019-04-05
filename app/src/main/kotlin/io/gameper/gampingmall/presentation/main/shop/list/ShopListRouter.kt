package io.gameper.gampingmall.presentation.main.shop.list

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.list.di.ShopListScope
import javax.inject.Inject

@ShopListScope
class ShopListRouter @Inject constructor(): BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf()
}