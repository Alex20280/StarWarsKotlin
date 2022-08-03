package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.data.network.RetrofitProvider
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepositoryImpl
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepositoryIml
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit

fun repositoryModule() = module {

    single<MovieApi> {
        val retrofit = get<Retrofit>()
        retrofit.create(MovieApi::class.java)
    }

    single<MovieApiRepository> {
        MovieApiRepositoryImpl(api = get())
    }

    single <MovieDbRepository> {
        MovieDbRepositoryIml(androidApplication())
    }
}