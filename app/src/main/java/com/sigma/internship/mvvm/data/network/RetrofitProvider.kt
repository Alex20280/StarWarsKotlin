package com.sigma.internship.mvvm.data.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}