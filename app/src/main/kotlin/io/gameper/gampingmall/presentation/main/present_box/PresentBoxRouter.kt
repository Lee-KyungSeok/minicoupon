package io.gameper.gampingmall.presentation.main.present_box

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxScope
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentView
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentView
import java.lang.Exception
import javax.inject.Inject

@PresentBoxScope
class PresentBoxRouter @Inject constructor(
    private val receivedPresentNodeHolder: ReceivedPresentNodeHolder,
    private val sentPresentNodeHolder: SentPresentNodeHolder
) : BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf(receivedPresentNodeHolder, sentPresentNodeHolder)

    fun startReceivedPresent(): ReceivedPresentView {
        receivedPresentNodeHolder.view ?: attachNode(receivedPresentNodeHolder)
        return receivedPresentNodeHolder.view ?: throw Exception("cannot find receivedPresentNodeHolder")
    }

    fun startSentPresent(): SentPresentView {
        sentPresentNodeHolder.view ?: attachNode(sentPresentNodeHolder)
        return sentPresentNodeHolder.view ?: throw Exception("cannot find sentPresentNodeHolder")
    }
}