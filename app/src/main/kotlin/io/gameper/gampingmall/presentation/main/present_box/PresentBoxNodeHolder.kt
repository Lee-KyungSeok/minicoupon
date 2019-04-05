package io.gameper.gampingmall.presentation.main.present_box

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.di.MainComponent
import io.gameper.gampingmall.presentation.main.present_box.di.DaggerPresentBoxComponent

class PresentBoxNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: MainComponent
) : ViewNodeHolder<PresentBoxView, PresentBoxRouter>(inflater, parent, NodeName.PRESENT_BOX) {

    override val layout: Int
        get() = R.layout.view_present_box

    override fun build(): PresentBoxRouter {
        val view = buildView()

        val component =  DaggerPresentBoxComponent.builder()
            .mainComponent(parentComponent)
            .build()

        component.inject(this)
        component.inject(view)

        attachView()
        return component.router()
    }
}