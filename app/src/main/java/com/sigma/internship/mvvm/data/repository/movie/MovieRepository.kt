package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel


interface MovieRepository {

    suspend fun savePopularMovies(): MutableList<MovieLocalModel>

    suspend fun saveMovieCast(): MutableList<CastLocal>

    suspend fun getPopularMovies(): MutableList<MovieLocalModel>

    suspend fun getPopularMovieCast(): MutableList<CastLocalModel>

}