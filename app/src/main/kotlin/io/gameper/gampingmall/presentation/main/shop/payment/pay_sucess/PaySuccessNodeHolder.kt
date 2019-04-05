package io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.BR
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ViewShopPaymentSuccessBinding
import io.gameper.gampingmall.presentation.base.node_holder.BindingViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.payment.di.PaymentComponent
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.di.DaggerPaySuccessComponent
import javax.inject.Inject

class PaySuccessNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: PaymentComponent
) : BindingViewNodeHolder<PaySuccessRouter, ViewShopPaymentSuccessBinding>(inflater, parent, NodeName.PAY_SUCCESS) {

    @Inject
    lateinit var paySuccessViewModel: PaySuccessViewModel

    override val layout: Int
        get() = R.layout.view_shop_payment_success

    override fun build(): PaySuccessRouter {

        val component = DaggerPaySuccessComponent.builder()
            .paymentComponent(parentComponent)
            .build()
        component.inject(this)

        buildAndAttachView(paySuccessViewModel, BR.viewModel)

        return component.router()
    }
}