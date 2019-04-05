package io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.di.PurchaseSelectorScope
import javax.inject.Inject

@PurchaseSelectorScope
class PurchaseSelectorRouter @Inject constructor() : BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf()
}