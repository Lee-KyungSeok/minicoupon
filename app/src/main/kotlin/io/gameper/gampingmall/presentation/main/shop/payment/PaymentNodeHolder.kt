package io.gameper.gampingmall.presentation.main.shop.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.BR
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ViewShopPaymentBinding
import io.gameper.gampingmall.presentation.base.node_holder.BindingViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent
import io.gameper.gampingmall.presentation.main.shop.payment.di.DaggerPaymentComponent
import javax.inject.Inject

class PaymentNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ShopComponent
): BindingViewNodeHolder<PaymentRouter, ViewShopPaymentBinding>(inflater, parent, NodeName.PAYMENT) {

    @Inject
    lateinit var paymentViewModel: PaymentViewModel

    override val layout: Int
        get() = R.layout.view_shop_payment

    override fun build(): PaymentRouter {

        val component = DaggerPaymentComponent.builder()
            .shopComponent(parentComponent)
            .build()

        component.inject(this)
        buildAndAttachView(paymentViewModel, BR.viewModel)

        return component.router()
    }
}