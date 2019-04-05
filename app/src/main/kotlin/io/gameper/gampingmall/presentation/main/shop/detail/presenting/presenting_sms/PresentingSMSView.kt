package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import io.gameper.gampingmall.databinding.ViewShopDetailPresentingSmsBinding
import javax.inject.Inject

class PresentingSMSView  @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @Inject
    lateinit var presentingSMSViewModel: PresentingSMSViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        bindingViewModel()
    }

    private fun bindingViewModel() {
        DataBindingUtil.bind<ViewShopDetailPresentingSmsBinding>(this)?.viewModel = presentingSMSViewModel
    }
}