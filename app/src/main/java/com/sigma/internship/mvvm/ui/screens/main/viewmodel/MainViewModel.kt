package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<MutableList<MovieAndDetailsUi>>
    abstract val getMovieAndDetailsById: LiveData<MutableList<MovieAndDetailsUi>>
    abstract val getCastById: LiveData<MutableList<CastUi>>

    abstract suspend fun saveMovies()

    abstract suspend fun saveDetailsById(id: Int)

    abstract suspend fun saveCastById(id: Int)

    abstract suspend fun getMovieIds(): List<Int>

    abstract fun getPopularMovies()

    abstract suspend fun getMovieByIdFromDb(id: Int)

     abstract suspend fun getCastFromDb(id: Int)


}


