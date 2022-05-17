package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<MutableList<MovieLocalModel>>

    abstract val getMovieDurationLocalModel: LiveData<MutableList<MovieDurationLocalModel>>

    abstract val getCastLocal: LiveData<MutableList<CastLocal>>

    public abstract fun getPopularMovies()

    public abstract fun getMovieDuration()

    public abstract fun getCrewAndCast()


}