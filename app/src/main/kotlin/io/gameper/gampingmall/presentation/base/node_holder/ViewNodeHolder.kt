package io.gameper.gampingmall.presentation.base.node_holder

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.exceptions.ViewIsAlreadyAttachedException

abstract class ViewNodeHolder<out V: View, R: BaseRouter>(
    private val inflater: LayoutInflater,
    protected val parent: ViewGroup,
    nodeName: NodeName
) : BaseNodeHolder<R>(nodeName) {

    private var view: V? = null

    abstract val layout: Int

    private fun destroyView() {
        if(view != null) {
            Log.i(">>>>", "destroyView " + this.nodeName)
            parent.removeView(view)
            view = null
        }
    }

    override fun destroy() {
        super.destroy()
        destroyView()
    }

    @Suppress("UNCHECKED_CAST")
    protected fun buildView(): V {
        if(view != null) {
            throw ViewIsAlreadyAttachedException(this)
        }
        Log.i(">>>>", "buildView " + this.nodeName)
        val v = inflater.inflate(layout, parent, false) as V
        view = v
        return v
    }

    protected fun attachView() {
        Log.i(">>>>", "attachView " + this.nodeName)
        parent.addView(view)
    }
}