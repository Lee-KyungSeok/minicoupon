package io.gameper.gampingmall.presentation.main.present_box.received_present.di

import android.view.LayoutInflater
import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentInteractor
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentRouter
import io.gameper.gampingmall.presentation.main.present_box.received_present.ReceivedPresentView
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailInteractor
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailNodeHolder

@ReceivedPresentScope
@Component(
    dependencies = [PresentBoxComponent::class],
    modules = [ReceivedPresentComponent.ReceivedModule::class]
)
interface ReceivedPresentComponent : ActivityComponent {
    fun inject(receivedPresentView: ReceivedPresentView)
    fun inject(receivedPresentNodeHolder: ReceivedPresentNodeHolder)
    fun interactor(): ReceivedPresentInteractor
    fun router(): ReceivedPresentRouter

    @Module
    class ReceivedModule(private val view: ReceivedPresentView) {

        @Provides
        @ReceivedPresentScope
        internal fun provideView() : ReceivedPresentView = view

        @Provides
        @ReceivedPresentScope
        internal fun providePresenter(): ReceivedPresentInteractor.Presenter = view

        @Provides
        @ReceivedPresentScope
        internal fun provideReceivedDetailNodeHolder(
            inflater: LayoutInflater,
            mainView: MainView,
            component: ReceivedPresentComponent
        ): ReceivedDetailNodeHolder =
            ReceivedDetailNodeHolder(inflater, mainView, component)

        @Provides
        @ReceivedPresentScope
        internal fun provideReceivedDetailListener(interactor: ReceivedPresentInteractor): ReceivedDetailInteractor.Listener = interactor
    }

    fun receivedDetailListener(): ReceivedDetailInteractor.Listener
}