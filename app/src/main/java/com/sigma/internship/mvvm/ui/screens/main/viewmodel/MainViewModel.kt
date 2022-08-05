package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.ui.base.BaseViewModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract val getMovies: LiveData<List<MovieLocalModel>>
    abstract val getCast: LiveData<List<CastLocal>>

    abstract suspend fun saveMovies()

    abstract suspend fun saveMoviesById(id: Int)

    abstract suspend fun saveCastById(id: Int)

    abstract suspend fun getAllMoviesFromDb()

    abstract suspend fun getMovieByIdFromDb(id: Int)

     abstract suspend fun getCastFromDb(id: Int)


}


