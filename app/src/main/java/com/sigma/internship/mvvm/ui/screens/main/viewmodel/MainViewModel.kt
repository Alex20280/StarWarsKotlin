package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.db.entities.CastDb
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.entities.ResultDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getPopularMovies: LiveData<List<ResultDbModel>>
    abstract val getMovieDetails: LiveData<List<MovieDbModel>>
    abstract val getCast: LiveData<List<MovieWithCastDbModel>>

    abstract fun savePopularMovies()

    abstract fun saveMovieDetails(id: Int)

    abstract fun saveCast(id: Int)

    abstract fun getPopularMoviesFromDb()

    abstract fun getMovieDetails(id: Int)

    abstract fun getCast(id: Int)


}