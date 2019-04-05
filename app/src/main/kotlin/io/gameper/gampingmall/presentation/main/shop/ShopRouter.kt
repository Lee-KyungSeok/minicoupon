package io.gameper.gampingmall.presentation.main.shop

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.detail.ShopDetailNodeHolder
import io.gameper.gampingmall.presentation.main.shop.di.ShopScope
import io.gameper.gampingmall.presentation.main.shop.list.ShopListNodeHolder
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentNodeHolder
import javax.inject.Inject

@ShopScope
class ShopRouter @Inject constructor(
    private val shopListNodeHolder: ShopListNodeHolder,
    private val shopDetailNodeHolder: ShopDetailNodeHolder,
    private val paymentNodeHolder: PaymentNodeHolder
) : BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf(shopListNodeHolder, shopDetailNodeHolder, paymentNodeHolder)

    fun startShopList() {
        detachNode(shopDetailNodeHolder)
        attachNode(shopListNodeHolder)
    }

    fun startShopDetail() {
        detachNode(shopListNodeHolder)
        detachNode(paymentNodeHolder)
        attachNode(shopDetailNodeHolder)
    }

    fun startPayment() {
        detachNode(shopListNodeHolder)
        detachNode(shopDetailNodeHolder)
        attachNode(paymentNodeHolder)
    }
}