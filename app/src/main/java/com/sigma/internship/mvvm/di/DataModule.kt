package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.data.db.MoviesDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun dataModule() = module {

    single {
        MoviesDatabase.getInstance(androidApplication())
    }

    single {
        get<MoviesDatabase>().getMovieDetailsDao()
    }

    single {
        get<MoviesDatabase>().getMovieDetailsWithId()
    }

    single {
        get<MoviesDatabase>().getMovieAndCastWithId()
    }
}



/*
    single {
        get<MoviesDatabase>().usersDao()
    }
*/