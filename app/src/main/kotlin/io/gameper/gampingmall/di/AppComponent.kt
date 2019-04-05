package io.gameper.gampingmall.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.gameper.gampingmall.GampingMallApplication
import io.gameper.gampingmall.di.data.DataModule
import io.gameper.gampingmall.di.domain.DomainModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    DomainModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AppDependencies, AndroidInjector<GampingMallApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}