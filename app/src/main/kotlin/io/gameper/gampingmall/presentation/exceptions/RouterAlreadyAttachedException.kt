package io.gameper.gampingmall.presentation.exceptions

import io.gameper.gampingmall.presentation.base.router.BaseRouter

class RouterAlreadyAttachedException(private val router: BaseRouter) : Exception() {

    override val message: String?
        get() = "Router ${router.javaClass.simpleName} is already attached"
}