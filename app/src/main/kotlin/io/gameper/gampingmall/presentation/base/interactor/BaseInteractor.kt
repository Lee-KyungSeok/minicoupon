package io.gameper.gampingmall.presentation.base.interactor

import android.os.Parcelable
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.base.state.NodeState

abstract class BaseInteractor<R: BaseRouter>(
    protected var router: R,
    protected var activityState: ActivityState
) {
    protected val nodeState: NodeState? = activityState.findNodeState(router.javaClass)

    protected val nodeStateData: Parcelable? = nodeState?.data

    open fun restoreState() {
        nodeState?.let {
            router.setState(it)
        }
    }

    fun hasSavedState(): Boolean {
        return activityState.findNodeState(router.javaClass) != null
    }
}