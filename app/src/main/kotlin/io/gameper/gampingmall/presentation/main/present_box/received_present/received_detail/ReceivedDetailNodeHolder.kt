package io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.BR
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ViewPresentBoxReceivedDetailBinding
import io.gameper.gampingmall.presentation.base.node_holder.BindingViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.ReceivedPresentComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.di.DaggerReceivedDetailComponent
import javax.inject.Inject

class ReceivedDetailNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ReceivedPresentComponent
): BindingViewNodeHolder<ReceivedDetailRouter, ViewPresentBoxReceivedDetailBinding>(inflater, parent, NodeName.RECEIVED_PRESENT_DETAIL) {

    @Inject
    lateinit var viewModel: ReceivedDetailViewModel

    override val layout: Int
        get() = R.layout.view_present_box_received_detail

    override fun build(): ReceivedDetailRouter {
        val component = DaggerReceivedDetailComponent.builder()
            .receivedPresentComponent(parentComponent)
            .build()

        component.inject(this)

        buildAndAttachView(viewModel, BR.viewModel)

        return component.router()
    }
}