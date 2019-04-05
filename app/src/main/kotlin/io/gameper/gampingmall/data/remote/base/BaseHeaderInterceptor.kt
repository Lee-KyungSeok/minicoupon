package io.gameper.gampingmall.data.remote.base

import okhttp3.Interceptor
import okhttp3.Response

class BaseHeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
        val newRequest = request().newBuilder().run {
            addHeader("app-os", "aos")
            addHeader("app-version", "1.0.0")
            build()
        }
        proceed(newRequest)
    }
}