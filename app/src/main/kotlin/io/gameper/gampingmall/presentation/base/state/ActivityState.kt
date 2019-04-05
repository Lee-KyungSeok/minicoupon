package io.gameper.gampingmall.presentation.base.state

import android.os.Parcelable
import io.gameper.gampingmall.presentation.base.router.BaseRouter
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class ActivityState(
    private val backStack: Stack<String> = Stack(),
    private val stateMap: Map<String, NodeState> = mapOf()
) : Parcelable {

    fun findNodeState(routerClass: Class<out BaseRouter>): NodeState? = stateMap[routerClass.simpleName]

    fun addToBackStack(_class: Class<out BaseRouter>) = backStack.add(_class.simpleName) //TODO replace to canonical name after testing

    fun isLastInBackStack(_class: Class<out BaseRouter>): Boolean =
        !backStack.isEmpty() && backStack.peek() == _class.simpleName //TODO replace to canonical name after testing

    fun popLastInBackStack() {
        backStack.pop()
    }

    fun removeFromBackStack(_class: Class<out BaseRouter>) {
        backStack.remove(_class.simpleName) //TODO replace to canonical name after testing
    }
}