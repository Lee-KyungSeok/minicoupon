package io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.di

import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.di.PresentingComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.*

@PresentingSMSScope
@Component(
    dependencies = [PresentingComponent::class],
    modules = [PresentingSMSComponent.PresentingSMSModule::class]
)
interface PresentingSMSComponent {

    fun inject(presentingSMSNodeHolder: PresentingSMSNodeHolder)
    fun inject(presentingSMSView: PresentingSMSView)
    fun interactor(): PresentingSMSInteractor
    fun router(): PresentingSMSRouter
    fun view(): PresentingSMSView
    fun viewUseCase(): PresentingSMSViewUseCase

    @Module
    class PresentingSMSModule(private val view: PresentingSMSView) {

        @Provides
        @PresentingSMSScope
        fun providePresentingSMSView(): PresentingSMSView = view
    }
}