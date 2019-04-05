package io.gameper.gampingmall.presentation.main.shop.detail.presenting

import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.BR
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.ViewShopDetailPresentnigBinding
import io.gameper.gampingmall.presentation.base.node_holder.BindingViewNodeHolder
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.DaggerPresentingComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingComponent
import javax.inject.Inject

class PresentingNodeHolder (
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ShopDetailComponent
) : ViewNodeHolder<PresentingView, PresentingRouter>(inflater, parent, NodeName.PRESENTING) {

    override val layout: Int
        get() = R.layout.view_shop_detail_presentnig

    override fun build(): PresentingRouter {
        val view = buildView()

        val component = DaggerPresentingComponent.builder()
            .presentingModule(PresentingComponent.PresentingModule(view))
            .shopDetailComponent(parentComponent)
            .build()

        component.inject(view)
        component.inject(this)

        attachView()

        return component.router()
    }

}