package io.gameper.gampingmall.presentation.base.interactor

import io.gameper.gampingmall.presentation.base.StateDateProvider
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.base.state.ActivityState

abstract class StateInteractor<R: BaseRouter>(
    router: R,
    activityState: ActivityState
) : BaseInteractor<R>(router, activityState), StateDateProvider {

    init {
        /*
         * If interactor need to store data after Activity recreation, we can set data source to router.
         * Router will get and save data when Activity will call onSaveInstanceState.
         */
        @Suppress("LeakingThis")
        router.setStateDataProvider(this)
    }

    override fun restoreState() {
        // 중복코드 ??? 왜 이런지 아직은.... ㅜ
        val state = nodeState
        if (state != null) {
            router.setState(state)
        }
//        state?.let {
//            router.setState(it)
//        }
//        super.restoreState()
    }
}