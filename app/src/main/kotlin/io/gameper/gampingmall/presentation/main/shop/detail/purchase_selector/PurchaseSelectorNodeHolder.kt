package io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import io.gameper.gampingmall.R
import io.gameper.gampingmall.databinding.WidgetShopDetailPurchaseBinding
import io.gameper.gampingmall.presentation.base.node_holder.ViewNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailComponent
import io.gameper.gampingmall.presentation.main.shop.detail.purchase_selector.di.DaggerPurchaseSelectorComponent
import javax.inject.Inject

class PurchaseSelectorNodeHolder(
    inflater: LayoutInflater,
    parent: ViewGroup,
    private val parentComponent: ShopDetailComponent
) : ViewNodeHolder<View, PurchaseSelectorRouter>(inflater, parent, NodeName.PURCHASE_SELECTOR) {

    @Inject
    lateinit var purchaseSelectorViewModel: PurchaseSelectorViewModel

    override val layout: Int
        get() = R.layout.widget_shop_detail_purchase

    override fun build(): PurchaseSelectorRouter {
        val view = buildView()
        val params = view.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.BOTTOM
        view.layoutParams = params

        val component = DaggerPurchaseSelectorComponent.builder()
            .shopDetailComponent(parentComponent)
            .build()

        component.inject(this)

        bindingViewModel(view)
        attachView()

        return component.router()
    }

    private fun bindingViewModel(view: View) {
        DataBindingUtil.bind<WidgetShopDetailPurchaseBinding>(view)?.viewModel = purchaseSelectorViewModel
    }
}