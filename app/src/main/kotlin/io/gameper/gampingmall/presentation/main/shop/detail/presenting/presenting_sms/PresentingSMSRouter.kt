package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.PresentingSMSScope
import javax.inject.Inject

@PresentingSMSScope
class PresentingSMSRouter @Inject constructor(): BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf()
}