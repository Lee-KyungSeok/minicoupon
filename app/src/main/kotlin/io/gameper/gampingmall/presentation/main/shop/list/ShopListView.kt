package io.gameper.gampingmall.presentation.main.shop.list

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import io.gameper.gampingmall.databinding.ViewShopListBinding
import kotlinx.android.synthetic.main.view_shop_list.view.*
import javax.inject.Inject


class ShopListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var shopListViewModel: ShopListViewModel

    @Inject
    lateinit var shopListAdapter: ShopListAdapter

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        makeStrike()
        setRecyclerView()
        bindingViewModel()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

    private fun makeStrike() {
        textViewMainShopSalePrice.paintFlags = (textViewMainShopSalePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
    }

    private fun setRecyclerView() {
        recyclerViewMainShopList.adapter = shopListAdapter
        val width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8f, resources.displayMetrics).toInt()
        val decoration = ShopListItemDecoration(spacing = width)
        recyclerViewMainShopList.addItemDecoration(decoration)
    }

    private fun bindingViewModel() {
        DataBindingUtil.bind<ViewShopListBinding>(this)?.viewModel = shopListViewModel
    }
}