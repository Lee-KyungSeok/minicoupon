package io.gameper.gampingmall.presentation.main.present_box.sent_present.di

import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.present_box.di.PresentBoxComponent
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentInteractor
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentRouter
import io.gameper.gampingmall.presentation.main.present_box.sent_present.SentPresentView

@SentPresentScope
@Component(
    dependencies = [PresentBoxComponent::class],
    modules = [SentPresentComponent.SentPresentModule::class]
)
interface SentPresentComponent: ActivityComponent {

    fun inject(sentPresentView: SentPresentView)
    fun inject(sentPresentNodeHolder: SentPresentNodeHolder)
    fun interactor(): SentPresentInteractor
    fun router(): SentPresentRouter

    @Module
    class SentPresentModule(private val view: SentPresentView) {

        @Provides
        @SentPresentScope
        internal fun providesView() : SentPresentView = view

        @Provides
        @SentPresentScope
        internal fun providesPresenter(): SentPresentInteractor.Presenter = view
    }
}