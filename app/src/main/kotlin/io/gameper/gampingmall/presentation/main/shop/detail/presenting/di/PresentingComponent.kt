package io.gameper.gampingmall.presentation.main.shop.detail.presenting.di

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.Component
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.R
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.detail.di.ShopDetailComponent
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingInteractor
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingNodeHolder
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingRouter
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.PresentingView
import io.gameper.gampingmall.presentation.main.shop.detail.presenting.presenting_sms.PresentingSMSNodeHolder
import javax.inject.Named

@PresentingScope
@Component(
    dependencies = [ShopDetailComponent::class],
    modules = [PresentingComponent.PresentingModule::class]
)
interface PresentingComponent: ActivityComponent {

    fun inject(presentingNodeHolder: PresentingNodeHolder)
    fun inject(presentView: PresentingView)
    fun interactor(): PresentingInteractor
    fun router(): PresentingRouter

    @Module
    class PresentingModule(private val view: PresentingView) {

        @Provides
        @PresentingScope
        fun providePresentingView(): PresentingView = view

        @Provides
        @PresentingScope
        @Named("containerPresentWay")
        fun providePresentingSelectorSpace(): ViewGroup = view.findViewById(R.id.containerPresentWay)

        @Provides
        @PresentingScope
        fun providePresentingSMSNodeHolder(
            inflater: LayoutInflater,
            @Named("containerPresentWay") containerPresentWay: ViewGroup,
            component: PresentingComponent
        ): PresentingSMSNodeHolder =
                PresentingSMSNodeHolder(inflater, containerPresentWay, component)
    }
}