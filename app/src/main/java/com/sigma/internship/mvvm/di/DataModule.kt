package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.network.RetrofitProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun dataModule() = module {

    single {
        get<MoviesDatabase>().getMovieDao()
    }

    single {
        MoviesDatabase.getInstance(androidApplication())
    }

    single {
        RetrofitProvider().getInstance()
    }
}



/*
    single {
        get<MoviesDatabase>().usersDao()
    }
*/