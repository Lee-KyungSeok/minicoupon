package io.gameper.gampingmall.presentation.main.present_box.received_present

import io.gameper.gampingmall.domain.interactor.product.GetOrdersUseCase
import io.gameper.gampingmall.entity.Product
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.ReceivedPresentScope
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailInteractor
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.gameper.gampingmall.utils.Quadruple
import javax.inject.Inject

@ReceivedPresentScope
class ReceivedPresentInteractor @Inject constructor(
    router: ReceivedPresentRouter,
    activityState: ActivityState,
    private val giftWrapper: GiftWrapper,
    private val orderWrapper: OrderWrapper,
    private val presenter: Presenter,
    private val getOrdersUseCase: GetOrdersUseCase,
    private val rxLifeCycleActivityBinder: RxLifeCycleActivityBinder
): BaseInteractor<ReceivedPresentRouter>(router, activityState), ReceivedDetailInteractor.Listener {

    fun requestReceivedGiftAll() {
        getOrdersUseCase.execute(
            Quadruple(orderWrapper.tempEmail, "complete", null, 0) // Todo 테스트 위해 null 입력 (in 으로 변경)
        ).compose(rxLifeCycleActivityBinder.bindToLifecycle())
        .map {
            it.map {order ->
                order.product!!
            }
        }
        .subscribe {
            presenter.updateReceived(it)
        }
    }

    fun showReceivedDetail(product: Product?) {
        giftWrapper.product = product
        product?.let {
            router.attachReceivedDetail()
        }
    }

    override fun onReceivedDetailCanceled() {
        router.detachReceivedDetail()
    }

    interface Presenter {
        fun updateReceived(productList: List<Product>)
    }
}