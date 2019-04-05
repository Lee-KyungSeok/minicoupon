package io.gameper.gampingmall.presentation.main.present_box.received_present

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.ReceivedPresentScope
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailNodeHolder
import javax.inject.Inject

@ReceivedPresentScope
class ReceivedPresentRouter @Inject constructor(
    private val receivedDetailNodeHolder: ReceivedDetailNodeHolder
): BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf(receivedDetailNodeHolder)

    fun attachReceivedDetail() {
        attachNode(receivedDetailNodeHolder)
    }

    fun detachReceivedDetail() {
        detachNode(receivedDetailNodeHolder)
    }
}