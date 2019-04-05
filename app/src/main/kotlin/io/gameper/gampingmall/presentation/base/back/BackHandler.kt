package io.gameper.gampingmall.presentation.base.back

import io.gameper.gampingmall.presentation.base.router.BaseRouter

internal interface BackHandler {
    fun onBackPressed(): Boolean
    fun isLastInBackStack(_class: Class<out BaseRouter>): Boolean
    fun popLastInBackStack()
    fun removeFromBackStack(_class: Class<out BaseRouter>)
}