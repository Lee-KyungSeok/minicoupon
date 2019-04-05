package io.gameper.gampingmall.presentation.main

import android.util.Log
import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.bottom.BottomNodeHolder
import io.gameper.gampingmall.presentation.main.bottom.BottomRouter
import io.gameper.gampingmall.presentation.main.di.MainScope
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxNodeHolder
import io.gameper.gampingmall.presentation.main.shop.ShopNodeHolder
import javax.inject.Inject

@MainScope
class MainRouter @Inject constructor(
    private val bottomNodeHolder: BottomNodeHolder,
    private val shopNodeHolder: ShopNodeHolder,
    private val presentBoxNodeHolder: PresentBoxNodeHolder
) : BaseRouter(){

    fun attachBottomNav() {
        getState()[BottomRouter::class.java.simpleName] ?: attachNode(bottomNodeHolder)
    }

    fun detachBottomNav() {
        detachNode(bottomNodeHolder)
    }

    fun startShopping() {
        detachNode(presentBoxNodeHolder)
        attachNode(shopNodeHolder)
        attachBottomNav()
    }

    fun startPresentBox() {
        detachNode(shopNodeHolder)
        attachNode(presentBoxNodeHolder)
        attachBottomNav()
    }

    override val holders: Set<BaseNodeHolder<*>>
        = setOf(shopNodeHolder, presentBoxNodeHolder)
}