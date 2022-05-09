package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.data.entities.UserLocalModel
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<MutableList<MovieLocalModel>>

    abstract fun getPopularMovies()
}