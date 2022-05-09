package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.data.network.MovieAPI
import com.sigma.internship.mvvm.data.network.RetrofitProvider
import com.sigma.internship.mvvm.data.repository.movie.MovieRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

fun repositoryModule() = module {

    single<Retrofit> {
        RetrofitProvider().retrofit
    }

    single<MovieAPI> {
        val retrofit = get<Retrofit>()
        retrofit.create(MovieAPI::class.java)
    }

    single<MovieRepository> {
        MovieRepositoryImpl(api = get())
    }
}