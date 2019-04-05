package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.DaggerPresentingSMSComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di.PresentingSMSComponent

class PresentingSMSNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: PresentingComponent
) : ViewNodeHolder<PresentingSMSView, PresentingSMSRouter>(inflater, parent, NodeName.PRESENTING_SMS) {
    override val layout: Int
        get() = R.layout.view_shop_detail_presenting_sms

    override fun build(): PresentingSMSRouter {
        val view = buildView()

        val component = DaggerPresentingSMSComponent.builder()
            .presentingComponent(parentComponent)
            .presentingSMSModule(PresentingSMSComponent.PresentingSMSModule(view))
            .build()

        component.inject(view)
        component.inject(this)

        attachView()

        return component.router()
    }
}