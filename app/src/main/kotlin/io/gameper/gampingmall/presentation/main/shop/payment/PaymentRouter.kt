package io.gameper.gampingmall.presentation.main.shop.payment

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.shop.payment.di.PaymentScope
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessNodeHolder
import javax.inject.Inject

@PaymentScope
class PaymentRouter @Inject constructor(
    private val paySuccessNodeHolder: PaySuccessNodeHolder
): BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf(paySuccessNodeHolder)

    fun attachPaySuccess() {
        attachNode(paySuccessNodeHolder)
    }
}