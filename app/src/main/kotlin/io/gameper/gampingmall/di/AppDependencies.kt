package io.gameper.gampingmall.di

import android.content.Context
import io.gameper.gampingmall.di.domain.GiftShopUseCaseDependency
import io.gameper.gampingmall.utils.ResourcesProvider
import javax.inject.Named

interface AppDependencies: GiftShopUseCaseDependency {

    @Named("appContext")
    fun context() : Context
    @Named("appResource")
    fun resourceProvider(): ResourcesProvider
}