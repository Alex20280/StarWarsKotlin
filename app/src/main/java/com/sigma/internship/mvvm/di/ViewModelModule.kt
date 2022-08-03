package com.sigma.internship.mvvm.di

import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel<MainViewModel> {
        MainViewModelImpl(repository = get(),dbRepository=get())
    }
}