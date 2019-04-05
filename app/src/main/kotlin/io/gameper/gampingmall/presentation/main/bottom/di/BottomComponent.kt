package io.gameper.gampingmall.presentation.main.bottom.di

import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.bottom.BottomInteractor
import io.gameper.gampingmall.presentation.main.bottom.BottomNodeHolder
import io.gameper.gampingmall.presentation.main.bottom.BottomRouter
import io.gameper.gampingmall.presentation.main.bottom.BottomView
import io.gameper.gampingmall.presentation.main.di.MainComponent
import io.gameper.gampingmall.presentation.main.present_box.PresentBoxNodeHolder

@BottomScope
@Component(
    dependencies = [MainComponent::class],
    modules = [BottomComponent.BottomModule::class]
)
interface BottomComponent {

    fun inject(bottomNodeHolder: BottomNodeHolder)
    fun inject(bottomView: BottomView)
    fun interactor(): BottomInteractor
    fun router(): BottomRouter

    @Module
    class BottomModule(private val view: BottomView) {

        @Provides
        @BottomScope
        fun provideBottomView(): BottomView = view
    }
}