package io.gameper.gampingmall.presentation.main.present_box.di

import android.view.LayoutInflater
import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.di.MainComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxInteractor
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxRouter
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxView
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentNodeHolder

@PresentBoxScope
@Component(
    dependencies = [MainComponent::class],
    modules = [PresentBoxComponent.PresentBoxModule::class]
)
interface PresentBoxComponent : ActivityComponent {
    fun inject(presentBoxNodeHolder: PresentBoxNodeHolder)
    fun inject(presentBoxView: PresentBoxView)
    fun interactor(): PresentBoxInteractor
    fun router(): PresentBoxRouter

    @Module
    class PresentBoxModule {

        @PresentBoxScope
        @Provides
        fun providesReceivedBoxNodeHolder(
            inflater: LayoutInflater,
            mainView: MainView,
            component: PresentBoxComponent
        ) : ReceivedPresentNodeHolder =
                ReceivedPresentNodeHolder(inflater, mainView, component)

        @PresentBoxScope
        @Provides
        fun providesSentBoxNodeHolder(
            inflater: LayoutInflater,
            mainView: MainView,
            component: PresentBoxComponent
        ) : SentPresentNodeHolder =
            SentPresentNodeHolder(inflater, mainView, component)
    }

    fun mainView(): MainView

}