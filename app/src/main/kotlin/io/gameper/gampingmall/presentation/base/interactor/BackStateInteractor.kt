package io.gameper.gampingmall.presentation.base.interactor

import io.gameper.gampingmall.presentation.base.back.BackHandler
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.ActivityState

abstract class BackStateInteractor<R: BaseRouter>(
    router: R,
    activityState: ActivityState
): StateInteractor<R>(router, activityState), BackHandler {

    init {
        @Suppress("LeakingThis")
        router.setBackHandler(this)
        activityState.addToBackStack(router.javaClass)
    }

    override fun isLastInBackStack(_class: Class<out BaseRouter>): Boolean {
        return activityState.isLastInBackStack(_class)
    }

    override fun popLastInBackStack() {
        return activityState.popLastInBackStack()
    }

    override fun removeFromBackStack(_class: Class<out BaseRouter>) {
        activityState.removeFromBackStack(_class)
    }

}