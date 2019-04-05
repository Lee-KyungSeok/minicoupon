package io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.di

import android.content.Context
import android.widget.Toast
import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.di.ReceivedPresentComponent
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailInteractor
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailNodeHolder
import io.gameper.gampingmall.presentation.main.present_box.received_present.received_detail.ReceivedDetailRouter
import javax.inject.Named

@ReceivedDetailScope
@Component(
    dependencies = [ReceivedPresentComponent::class],
    modules = [ReceivedDetailComponent.ReceivedDetailModule::class]
)
interface ReceivedDetailComponent: ActivityComponent {

    fun inject(receivedDetailNodeHolder: ReceivedDetailNodeHolder)
    fun interactor(): ReceivedDetailInteractor
    fun router(): ReceivedDetailRouter


    @Module
    class ReceivedDetailModule {

    }
}