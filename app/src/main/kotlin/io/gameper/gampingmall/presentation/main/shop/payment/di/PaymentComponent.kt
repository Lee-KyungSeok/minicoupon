package io.gameper.gampingmall.presentation.main.shop.payment.di

import dagger.Component
import io.gameper.gampingmall.presentation.base.di.ActivityComponent
import io.gameper.gampingmall.presentation.main.shop.di.ShopComponent
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentInteractor
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentNodeHolder
import io.gameper.gampingmall.presentation.main.shop.payment.PaymentRouter
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessInteractor

@PaymentScope
@Component(
    dependencies = [ShopComponent::class],
    modules = [PaymentModule::class]
)
interface PaymentComponent : ActivityComponent {

    fun inject(paymentNodeHolder: PaymentNodeHolder)

    fun mainView(): MainView
    fun interactor(): PaymentInteractor
    fun router(): PaymentRouter
    fun paySuccessListener(): PaySuccessInteractor.Listener
}