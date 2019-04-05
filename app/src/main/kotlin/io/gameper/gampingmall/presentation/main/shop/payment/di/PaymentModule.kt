package io.gameper.gampingmall.presentation.main.shop.payment.di

import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.presentation.main.MainView
import io.gameper.gampingmall.presentation.main.shop.payment.pay_sucess.PaySuccessNodeHolder

@Module
class PaymentModule {

    @PaymentScope
    @Provides
    fun providePaySuccessNodeHolder(
        inflater: LayoutInflater,
        mainView: MainView,
        component: PaymentComponent
    ) : PaySuccessNodeHolder = PaySuccessNodeHolder(inflater, mainView, component)
}