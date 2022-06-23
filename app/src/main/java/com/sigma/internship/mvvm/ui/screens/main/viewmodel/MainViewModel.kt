package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.PopularLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<MutableList<MovieLocalModel>>
    abstract val getMovieDetails: LiveData<MutableList<PopularLocalModel>>
    abstract val getCast: MutableLiveData<MutableList<CastLocalModel>>

    public abstract fun savePopularMovies()

    public abstract fun saveMovieDetails(id: Int)

    public abstract fun saveCast(id: Int)


}