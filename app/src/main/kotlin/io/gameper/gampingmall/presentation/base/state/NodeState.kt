package io.gameper.gampingmall.presentation.base.state

import android.os.Parcelable
import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NodeState(
    val data: Parcelable?,
    private val activeNodes: Set<NodeName> = emptySet()
) : Parcelable {

    fun contains(node: BaseNodeHolder<*>): Boolean {
        return activeNodes.contains(node.nodeName)
    }
}

enum class NodeName {
    BOTTOM,
    SHOP,
    SHOP_LIST,
    SHOP_DETAIL,
    PURCHASE_SELECTOR,
    PRESENTING,
    PRESENTING_SMS,
    PAYMENT,
    PAY_SUCCESS,
    PRESENT_BOX,
    RECEIVED_PRESENT,
    RECEIVED_PRESENT_DETAIL,
    SENT_PRESENT,
    SENT_PRESENT_DETAIL
}