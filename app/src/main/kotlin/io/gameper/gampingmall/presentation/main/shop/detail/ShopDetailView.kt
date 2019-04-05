package io.gameper.gampingmall.presentation.main.shop.detail

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import io.gameper.gampingmall.databinding.ViewShopDetailBinding
import javax.inject.Inject

class ShopDetailView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var shopDetailViewModel: ShopDetailViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        bindingViewModel()
    }

    private fun bindingViewModel() {
        DataBindingUtil.bind<ViewShopDetailBinding>(this)?.viewModel = shopDetailViewModel
    }
}