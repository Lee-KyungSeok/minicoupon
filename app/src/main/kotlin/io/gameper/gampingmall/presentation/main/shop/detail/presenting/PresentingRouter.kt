package io.gameper.gampingmall.presentation.main.shop.detail.presenting

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingScope
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.PresentingSMSNodeHolder
import javax.inject.Inject

@PresentingScope
class PresentingRouter @Inject constructor(
    private val presentingSMSNodeHolder: PresentingSMSNodeHolder
): BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf(presentingSMSNodeHolder)

    fun attachPresentingSMS() {
        attachNode(presentingSMSNodeHolder)
    }

    fun attachPresentingKakao() {

    }
}