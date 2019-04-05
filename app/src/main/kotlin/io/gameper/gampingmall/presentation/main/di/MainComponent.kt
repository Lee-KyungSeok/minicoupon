package io.gameper.gampingmall.presentation.main.di

import dagger.BindsInstance
import dagger.Component
import io.gameper.gampingmall.di.AppDependencies
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.MainActivity
import io.gameper.gampingmall.presentation.main.MainInteractor
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.bottom.BottomInteractor
import io.gameper.gampingmall.presentation.main.shop.ShopInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor


@MainScope
@Component(
    dependencies = [AppDependencies::class],
    modules = [MainModule::class])
interface MainComponent : ActivityComponent {

    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder
        fun mainModule(module: MainModule): Builder
        fun appDependencies(appDependencies: AppDependencies): Builder
        fun build(): MainComponent
    }

    fun interactor() : MainInteractor
    fun mainView(): MainView
    fun paySuccessListener(): PaySuccessInteractor.Listener
    fun bottomListener(): BottomInteractor.Listener
    fun shopListener(): ShopInteractor.Listener
}