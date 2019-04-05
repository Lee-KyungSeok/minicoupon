package io.gameper.gampingmall.presentation.main.shop.detail

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailScope
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.PurchaseSelectorNodeHolder
import javax.inject.Inject

@ShopDetailScope
class ShopDetailRouter @Inject constructor(
    private val purchaseSelectorNodeHolder: PurchaseSelectorNodeHolder,
    private val presentingNodeHolder: PresentingNodeHolder
) : BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf(purchaseSelectorNodeHolder, presentingNodeHolder)

    fun attachPurchaseSelector() {
        attachNode(purchaseSelectorNodeHolder)
    }

    fun detachPurchaseSelector() {
        detachNode(purchaseSelectorNodeHolder)
    }

    fun attachPresenting() {
        attachNode(presentingNodeHolder)
    }

    fun detachPresenting() {
        detachNode(presentingNodeHolder)
    }
}