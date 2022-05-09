package com.sigma.internship.mvvm.data.network


import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitProvider {

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun initClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .addNetworkInterceptor { chain ->
                val request: Request
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .addHeader("Content-Type", "application/json")
                request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }
}