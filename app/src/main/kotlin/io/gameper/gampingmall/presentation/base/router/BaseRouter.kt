package io.gameper.gampingmall.presentation.base.router

import android.util.Log
import androidx.annotation.UiThread
import io.gameper.gampingmall.presentation.base.StateDateProvider
import io.gameper.gampingmall.presentation.base.back.BackHandler
import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.base.state.NodeState
import io.gameper.gampingmall.presentation.exceptions.RouterAlreadyAttachedException
import io.gameper.gampingmall.presentation.exceptions.ViewIsAlreadyAttachedException

abstract class BaseRouter {

    private val children = HashMap<Class<out BaseRouter>, BaseRouter>()

    private fun getChildrenState(): MutableMap<String, NodeState> {
        val stateMap = HashMap<String, NodeState>()
        children.values.forEach {
            stateMap.putAll(it.getState())
        }
        return stateMap
    }

    private var stateDataProvider: StateDateProvider? = null

    internal fun setStateDataProvider(provider: StateDateProvider) {
        stateDataProvider = provider
    }

    fun getState(): Map<String, NodeState> {
        val state = getChildrenState()
        val stateData = stateDataProvider?.run { this.onSaveData() }
        state[this.javaClass.simpleName] = NodeState(stateData, activeNodes())
        return state
    }

    private var backHandler: BackHandler? = null

    internal fun setBackHandler(handler: BackHandler?) {
        backHandler = handler
    }

    @UiThread
    protected fun attachNode(nodeHolder: BaseNodeHolder<*>) {
        try {
            attachRouter(nodeHolder.build())
        } catch (e: ViewIsAlreadyAttachedException) {
            // Todo 에러 처리 필요!
        }
    }

    @UiThread
    protected fun detachNode(nodeHolder: BaseNodeHolder<*>) {
        nodeHolder.router?.let {
            detachRouter(it.javaClass)
            nodeHolder.destroy()
        }
    }

    private fun attachRouter(router: BaseRouter) {
        if (children.containsKey(router.javaClass)) {
            throw RouterAlreadyAttachedException(router)
        }
        children[router.javaClass] = router
    }

    private fun detachRouter(router: Class<out BaseRouter>) {
        children.remove(router)
    }

    abstract val holders: Set<BaseNodeHolder<*>>

    internal fun detachAllChildren() {
        holders.forEach { detachNode(it) }
    }

    private fun activeNodes(): Set<NodeName> {
        return holders.filter { it.isActive() }
            .map { it.nodeName }
            .toSet()
    }

    internal fun setState(state: NodeState) {
        holders.filter { state.contains(it) }
            .forEach { attachNode(it) }
    }


    fun onBackPressed(): Boolean {
        for (router in children.values) {
            if (router.onBackPressed()) {
                return true
            }
        }
        backHandler?.let {
            if (it.isLastInBackStack(this.javaClass)) {
                it.popLastInBackStack()
                return it.onBackPressed()
            }
        }

        return false
    }

    internal fun removeFromBackStack() {
        backHandler?.removeFromBackStack(this.javaClass)
    }
}