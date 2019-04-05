package io.gameper.gampingmall.presentation.main.shop.detail.presenting

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import io.gameper.gampingmall.databinding.ViewShopDetailPresentnigBinding
import javax.inject.Inject

class PresentingView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var shopPresentingViewModel: PresentingViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        bindingViewModel()
    }

    private fun bindingViewModel() {
        DataBindingUtil.bind<ViewShopDetailPresentnigBinding>(this)?.viewModel = shopPresentingViewModel
    }
}