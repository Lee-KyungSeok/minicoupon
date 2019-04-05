package io.gameper.gampingmall.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.domain.Schedulers
import io.gameper.gampingmall.utils.ResourcesProvider
import io.gameper.gampingmall.utils.ResourcesProviderImpl
import io.gameper.gampingmall.utils.scheduler.AppSchedulers
import io.gameper.gampingmall.utils.scheduler.IoSchedulers
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Named("appContext")
    @Singleton
    fun providesContext(application: Application) : Context = application.applicationContext

    @Provides
    @Named("appScheduler")
    @Singleton
    fun providesAppScheduler(): Schedulers = AppSchedulers()

    @Provides
    @Named("ioScheduler")
    @Singleton
    fun providesIoSchedulers(): Schedulers = IoSchedulers()

    @Provides
    @Singleton
    @Named("appResource")
    fun provideResourceProvider(@Named("appContext") context: Context) : ResourcesProvider = ResourcesProviderImpl(context)
}