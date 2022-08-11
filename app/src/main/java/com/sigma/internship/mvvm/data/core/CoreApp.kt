package com.sigma.internship.mvvm.data.core

import android.app.Application
import com.sigma.internship.mvvm.di.dataModule
import com.sigma.internship.mvvm.di.repositoryModule
import com.sigma.internship.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CoreApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CoreApp)
            modules(listOf(repositoryModule(), dataModule(), viewModelModule()))
        }
    }
}

//modules(listOf(dataModule(), viewModelModule(), repositoryModule()))