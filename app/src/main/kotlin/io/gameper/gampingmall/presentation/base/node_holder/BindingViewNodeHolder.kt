package io.gameper.gampingmall.presentation.base.node_holder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.exceptions.ViewIsAlreadyAttachedException

abstract class BindingViewNodeHolder<R: BaseRouter, B: ViewDataBinding>(
    private val inflater: LayoutInflater,
    protected val parent: ViewGroup,
    nodeName: NodeName
) : BaseNodeHolder<R>(nodeName) {

    private var view: View? = null

    abstract val layout: Int

    private fun destroyView() {
        if (view != null) {
            parent.removeView(view)
            view = null
        }
    }

    override fun destroy() {
        super.destroy()
        destroyView()
    }

    @Suppress("UNCHECKED_CAST")
    private fun buildView(): View {
        if (view != null) {
            throw ViewIsAlreadyAttachedException(this)
        }
        Log.i(">>>>", "buildView " + this.javaClass.simpleName)
        val v = inflater.inflate(layout, parent, false)
        view = v
        return v
    }

    private fun setupDataBinding(v: View, viewModel: Any, brId: Int) {
        val binding: B? = DataBindingUtil.bind(v)
        binding?.setVariable(brId, viewModel)
    }

    private fun attachView(viewModel: Any, brId: Int) {
        Log.i(">>>>", "attachView " + this.javaClass.simpleName)
        view?.let { setupDataBinding(it, viewModel, brId) }
        parent.addView(view)
    }

    protected fun buildAndAttachView(viewModel: Any, brId: Int) {
        buildView()
        attachView(viewModel, brId)
    }
}