package io.gameper.gampingmall.presentation.main.bottom

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.bottom.di.BottomComponent
import io.gameper.gampingmall.presentation.main.bottom.di.DaggerBottomComponent
import io.gameper.gampingmall.presentation.main.di.MainComponent

class BottomNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: MainComponent
): ViewNodeHolder<BottomView, BottomRouter>(inflater, parent, NodeName.BOTTOM) {

    override val layout: Int
        get() = R.layout.widget_bottom_navigation

    lateinit var view: BottomView


    override fun build(): BottomRouter {
        val view = buildView()
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.BOTTOM
        view.layoutParams = params

        val component = DaggerBottomComponent.builder()
            .mainComponent(parentComponent)
            .bottomModule(BottomComponent.BottomModule(view))
            .build()

        component.inject(view)
        component.inject(this)
        attachView()
        return component.router()
    }

}