package io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.di

import dagger.Component
import dagger.Module
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.payment.di.PaymentComponent
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessNodeHolder
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessRouter

@PaySuccessScope
@Component(
    dependencies = [PaymentComponent::class],
    modules = [PaySuccessComponent.PaySuccessModule::class]
)
interface PaySuccessComponent: ActivityComponent {

    fun inject(paySuccessNodeHolder: PaySuccessNodeHolder)
    fun interactor(): PaySuccessInteractor
    fun router(): PaySuccessRouter

    @Module
    class PaySuccessModule {

    }
}