package io.gameper.gampingmall.presentation.main.present_box.received_present

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.exceptions.ViewIsAlreadyAttachedException
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.DaggerReceivedPresentComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.ReceivedPresentComponent

class ReceivedPresentNodeHolder (
    private val inflater: LayoutInflater,
    private val parent: ViewGroup,
    private val parentComponent: PresentBoxComponent
): BaseNodeHolder<ReceivedPresentRouter>(NodeName.RECEIVED_PRESENT) {

//    @Inject
//    lateinit var paymentViewModel: PaymentViewModel


    var view: ReceivedPresentView? = null

    val layout: Int
        get()= R.layout.view_present_box_received

    @Suppress("UNCHECKED_CAST")
    private fun buildView(): ReceivedPresentView {
        if(view != null) {
            throw ViewIsAlreadyAttachedException(this)
        }
        Log.i(">>>>", "buildView " + this.nodeName)
        val v = inflater.inflate(layout, parent, false) as ReceivedPresentView
        view = v
        return v
    }

    override fun build(): ReceivedPresentRouter {
        val view = buildView()

        val component = DaggerReceivedPresentComponent.builder()
            .presentBoxComponent(parentComponent)
            .receivedModule(ReceivedPresentComponent.ReceivedModule(view))
            .build()

        component.inject(view)
        component.inject(this)

        return component.router()
    }
}