package io.gameper.gampingmall.presentation.main.present_box.sent_present

import io.gameper.gampingmall.domain.interactor.product.GetOrdersUseCase
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.present_box.sent_present.di.SentPresentScope
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.gameper.gampingmall.utils.Quadruple
import javax.inject.Inject

@SentPresentScope
class SentPresentInteractor  @Inject constructor(
    router: SentPresentRouter,
    activityState: ActivityState,
    private val orderWrapper: OrderWrapper,
    private val presenter: Presenter,
    private val getOrdersUseCase: GetOrdersUseCase,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): BaseInteractor<SentPresentRouter>(router, activityState) {

    fun requestSentGiftAll() {
        getOrdersUseCase.execute(
            Quadruple(orderWrapper.tempEmail, "complete", "out", 0)
        ).compose(rxLifeCycleActivityBinder.bindToLifecycle())
            .map {
                it.map {order ->
                    order.product!!
                }
            }
            .subscribe {
                presenter.updateSent(it)
            }
    }

    interface Presenter {
        fun updateSent(productList: List<Product>)
    }
}