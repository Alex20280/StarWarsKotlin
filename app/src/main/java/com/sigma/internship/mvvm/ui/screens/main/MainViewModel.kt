package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<MutableList<MovieLocalModel>>

    abstract val getCast: MutableLiveData<MutableList<CastLocalModel>>

    public abstract fun getPopularMovies()

    public abstract fun getCast()


}