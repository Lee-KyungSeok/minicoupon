package io.gameper.gampingmall.di.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Named("unauthorized") // unauthorized 로 구분 가능한 OkHttpClient 객체 제공
    @Singleton
    fun provideUnauthorizedOkHttpClient (
            loggingInterceptor: HttpLoggingInterceptor) : OkHttpClient  {

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

//    @Provides
//    @Named("authorized")
//    @Singleton
//    fun provideAuthorizedOkHttpClient (
//            loggingInterceptor: HttpLoggingInterceptor,
//            authInterceptor: AuthInterceptor) : OkHttpClient
//    = OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .addInterceptor(authInterceptor)
//            .build()

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {

        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

//    @Provides
//    @Singleton
//    fun providesAuthInterceptor(preference: AuthTokenPreference) : AuthInterceptor {
//        val token = preference.token ?: throw IllegalStateException("authToken cannot be null")
//        return AuthInterceptor(token)
//    }
}