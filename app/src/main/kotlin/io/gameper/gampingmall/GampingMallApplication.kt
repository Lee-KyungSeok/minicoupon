package io.gameper.gampingmall

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.gameper.gampingmall.di.AppComponent
import io.gameper.gampingmall.di.AppDependencies
import io.gameper.gampingmall.di.DaggerAppComponent

class GampingMallApplication: DaggerApplication() {

    private lateinit var component: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        component = DaggerAppComponent
            .builder()
            .application(this)
            .build()
        return component
    }

    fun appDependencies() = component

}

fun Context.appDependencies() : AppDependencies {
    return if (this is GampingMallApplication) {
        this.appDependencies()
    } else {
        (applicationContext as GampingMallApplication).appDependencies()
    }
}