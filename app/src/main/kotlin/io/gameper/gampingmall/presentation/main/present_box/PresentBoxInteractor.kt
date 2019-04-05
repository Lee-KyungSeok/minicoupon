package io.gameper.gampingmall.presentation.main.present_box

import io.gameper.gampingmall.presentation.base.interactor.BaseInteractor
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxScope
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentView
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentView
import javax.inject.Inject

@PresentBoxScope
class PresentBoxInteractor @Inject constructor(
    router: PresentBoxRouter,
    activityState: ActivityState
): BaseInteractor<PresentBoxRouter>(router, activityState) {

    fun onReceivedViewShow(): ReceivedPresentView {
        return router.startReceivedPresent()
    }

    fun onSentViewShow(): SentPresentView {
        return router.startSentPresent()
    }
}