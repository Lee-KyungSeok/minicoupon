package io.gameper.gampingmall.presentation.main.bottom

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import io.gameper.gampingmall.presentation.main.bottom.di.BottomScope
import javax.inject.Inject

@BottomScope
class BottomRouter @Inject constructor() : BaseRouter() {
    override val holders: Set<BaseNodeHolder<*>> = setOf()
}