package io.gameper.gampingmall.presentation.main.present_box.sent_present

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.present_box.sent_present.di.SentPresentScope
import javax.inject.Inject

@SentPresentScope
class SentPresentRouter @Inject constructor(): BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf()
}