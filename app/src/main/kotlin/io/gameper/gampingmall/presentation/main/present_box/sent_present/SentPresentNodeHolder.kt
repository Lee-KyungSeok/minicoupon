package io.gameper.gampingmall.presentation.main.present_box.sent_present

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.node_holder.BaseNodeHolder
import io.gameper.gampingmall.presentation.base.state.NodeName
import io.gameper.gampingmall.presentation.exceptions.ViewIsAlreadyAttachedException
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxComponent
import io.gameper.gampingmall.presentation.main.present_box.sent_present.di.DaggerSentPresentComponent
import io.gameper.gampingmall.presentation.main.present_box.sent_present.di.SentPresentComponent

class SentPresentNodeHolder (
    private val inflater: LayoutInflater,
    private val parent: ViewGroup,
    private val parentComponent: PresentBoxComponent
): BaseNodeHolder<SentPresentRouter>(NodeName.SENT_PRESENT) {

//    @Inject
//    lateinit var paymentViewModel: PaymentViewModel


    var view: SentPresentView? = null

    val layout: Int
        get()= R.layout.view_present_box_sent

    @Suppress("UNCHECKED_CAST")
    private fun buildView(): SentPresentView {
        if(view != null) {
            throw ViewIsAlreadyAttachedException(this)
        }
        Log.i(">>>>", "buildView " + this.nodeName)
        val v = inflater.inflate(layout, parent, false) as SentPresentView
        view = v
        return v
    }

    override fun build(): SentPresentRouter {
        val view = buildView()

        val component = DaggerSentPresentComponent.builder()
            .presentBoxComponent(parentComponent)
            .sentPresentModule(SentPresentComponent.SentPresentModule(view))
            .build()

        component.inject(view)
        component.inject(this)

        return component.router()
    }
}