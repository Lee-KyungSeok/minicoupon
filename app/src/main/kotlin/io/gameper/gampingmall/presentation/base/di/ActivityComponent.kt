package io.gameper.gampingmall.presentation.base.di

import android.content.Context
import android.view.LayoutInflater
import io.gameper.gampingmall.di.AppDependencies
import io.gameper.gampingmall.presentation.base.RxLifeCycleActivityBinder
import io.gameper.gampingmall.presentation.base.state.ActivityState
import io.gameper.gampingmall.presentation.model.GiftWrapper
import io.gameper.gampingmall.presentation.model.OrderWrapper
import io.gameper.gampingmall.utils.ToastProvider
import javax.inject.Named

/**
 * Created by lev.novikov
 * Date: 29/12/17.
 */

interface ActivityComponent: AppDependencies {

    @Named("mainContext")
    fun activity(): Context
    fun activityState(): ActivityState
    fun inflater(): LayoutInflater
    fun rxLifeCycleBinder(): RxLifeCycleActivityBinder
    fun giftWrapper(): GiftWrapper
    fun orderWrapper(): OrderWrapper

    @Named("activityToast")
    fun toastProvider(): ToastProvider
}
