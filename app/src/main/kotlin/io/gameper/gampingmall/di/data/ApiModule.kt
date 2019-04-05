package io.gameper.gampingmall.di.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.gameper.gampingmall.BuildConfig
import io.gameper.gampingmall.data.remote.product.api.ProductApi
import io.gameper.gampingmall.utils.DateDeserializer
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

//    // AuthApi 객체 제공
//    @Provides
//    @Singleton // 싱글턴으로 적용
//    fun provideAuthApi(
//            @Named("unauthorized")okHttpClient: OkHttpClient, // named 로 객체의 특성을 다르게 해서 대입할 수 있다.
//            callAdapter: CallAdapter.Factory,
//            converter: Converter.Factory) : AuthApi
//    = Retrofit.Builder()
//            .baseUrl("https://github.com/")
//            .client(okHttpClient)
//            .addCallAdapterFactory(callAdapter)
//            .addConverterFactory(converter)
//            .build()
//            .create(AuthApi::class.java)

    // GithubApi 객체 제공
    @Provides
    @Singleton
    fun provideGiftApi(
            @Named("unauthorized")okHttpClient: OkHttpClient,
            callAdapter: CallAdapter.Factory,
            converter: Converter.Factory) : ProductApi {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.GAMPPING_MALL_API)
            .client(okHttpClient)
            .addCallAdapterFactory(callAdapter)
            .addConverterFactory(converter)
            .build()
            .create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCallAdapterFactory() : CallAdapter.Factory = RxJava2CallAdapterFactory.createAsync()

    @Provides
    @Singleton
    fun provideConverterFactory() : Converter.Factory {
        val gson : Gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateDeserializer())
            .serializeNulls()
            .create()
        return GsonConverterFactory.create(gson)
    }
}