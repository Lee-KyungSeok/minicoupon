package io.gameper.gampingmall.presentation.main

import android.os.Parcelable
import android.util.Log
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.StateInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.base.state.NodeState
import io.gameper.gampingmall.presentation.main.bottom.BottomInteractor
import io.gameper.gampingmall.presentation.main.di.MainScope
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxNodeHolder
import io.gameper.gampingmall.presentation.main.shop.ShopInteractor
import io.gameper.gampingmall.presentation.main.shop.ShopNodeHolder
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@MainScope
class MainInteractor @Inject constructor(
    router: MainRouter,
    activityState: ActivityState,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): StateInteractor<MainRouter>(router, activityState), PaySuccessInteractor.Listener, BottomInteractor.Listener, ShopInteractor.Listener {

    private val mainStateSubject = BehaviorSubject.createDefault(MainState.SHOP)

    private var currentState: MainState? = null

    private val state: Map<String, NodeState>
        get() = router.getState()

    override fun onSaveData(): Parcelable? {
        return currentState?.let { MainData(it) }
    }

    override fun restoreState() {
        super.restoreState()
        nodeState?.let {
            val data: MainData? = it.data as MainData?
            data?.let {
                currentState = it.state
            }
        }

        mainStateSubject.distinctUntilChanged()
            .compose(rxLifeCycleActivityBinder.bindToLifecycle())
            .subscribe({
                changeState(it)
            }, {
                // Todo 에러처리 필요!
            })
    }

    private fun changeState(state: MainState) {
        if(state == currentState) {
            return
        }

        currentState = state

        when(state) {
            MainState.SHOP -> router.startShopping()
            MainState.PRESENT_BOX -> router.startPresentBox()
        }
    }

    internal fun onBackPressed(): Boolean {
        return router.onBackPressed()
    }

    fun getActivityState(): Parcelable? {
        return ActivityState(stateMap = state)
    }

    override fun onBottomChange(bottomId: Int) {
        when(bottomId) {
            R.id.bottom_menu_main_home -> mainStateSubject.onNext(MainState.SHOP)
            R.id.bottom_menu_main_present -> mainStateSubject.onNext(MainState.PRESENT_BOX)
        }
    }

    override fun onSelectItem(): Int {
        return when(currentState) {
            MainState.SHOP -> R.id.bottom_menu_main_home
            MainState.PRESENT_BOX -> R.id.bottom_menu_main_present
            else -> R.id.bottom_menu_main_account
        }
    }

    override fun onGoPresentClick() {
        router.detachAllChildren()
        mainStateSubject.onNext(MainState.PRESENT_BOX)
    }

    override fun onBackSuccessClick() {
        router.detachAllChildren()
        router.startShopping()
    }

    override fun onBottomGoneByShop() {
        router.detachBottomNav()
    }

    override fun onBottomVisibleByShop() {
        router.attachBottomNav()
    }
}