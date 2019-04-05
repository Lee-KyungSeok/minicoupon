package io.gameper.gampingmall.presentation.exceptions

import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder

class ViewIsAlreadyAttachedException(private val nodeHolder: BaseNodeHolder<*>) : Exception() {

    override val message: String?
        get() = "ViewNodeHolder ${nodeHolder.javaClass.simpleName} is already attached"
}