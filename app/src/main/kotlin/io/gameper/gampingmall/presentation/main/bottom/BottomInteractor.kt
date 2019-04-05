package io.gameper.gampingmall.presentation.main.bottom

import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.bottom.di.BottomScope
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxRouter
import io.gameper.gampingmall.presentation.main.shop.ShopRouter
import io.reactivex.subjects.BehaviorSubject

import javax.inject.Inject

@BottomScope
class BottomInteractor @Inject constructor(
    router: BottomRouter,
    activityState: ActivityState,
    private val listener: Listener
): BaseInteractor<BottomRouter>(router, activityState) {

    fun onBottomChange(bottomId: Int) {
        listener.onBottomChange(bottomId)
    }

    fun checkSelectedItemId() : Int {
        return listener.onSelectItem()
    }

    interface Listener {
        fun onBottomChange(bottomId: Int)
        fun onSelectItem(): Int
    }
}