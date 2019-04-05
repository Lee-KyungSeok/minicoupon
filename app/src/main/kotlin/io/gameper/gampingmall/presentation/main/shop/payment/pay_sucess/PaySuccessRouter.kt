package io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.di.PaySuccessScope
import javax.inject.Inject

@PaySuccessScope
class PaySuccessRouter @Inject constructor() : BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf()
}