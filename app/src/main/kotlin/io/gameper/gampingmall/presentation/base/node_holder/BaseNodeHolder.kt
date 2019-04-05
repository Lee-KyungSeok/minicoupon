package io.gameper.gampingmall.presentation.base.node_holder

import android.util.Log
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.NodeName
import javax.inject.Inject

abstract class BaseNodeHolder<R: BaseRouter>(val nodeName: NodeName) {

    @JvmField
    @Inject
    internal var router: R? = null

    internal fun isActive(): Boolean = router != null

    abstract fun build(): R

    open fun destroy() {
        Log.i(">>>>", "destroy " + this.javaClass.simpleName)
        router?.run {
            detachAllChildren()
            removeFromBackStack()
            this.setBackHandler(null)
            router = null
        }
    }
}