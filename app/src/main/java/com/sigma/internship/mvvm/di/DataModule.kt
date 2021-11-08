package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.data.db.TestDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun dataModule() = module {

    single {
        TestDatabase.getInstance(androidApplication())
    }

    single {
        get<TestDatabase>().usersDao()
    }
}