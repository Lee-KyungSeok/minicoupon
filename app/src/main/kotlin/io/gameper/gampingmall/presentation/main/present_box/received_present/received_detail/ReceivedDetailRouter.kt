package io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.di.ReceivedDetailScope
import javax.inject.Inject

@ReceivedDetailScope
class ReceivedDetailRouter @Inject constructor(): BaseRouter() {

    override val holders: Set<BaseNodeHolder<*>> = setOf()
}