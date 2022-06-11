package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MovieRepositoryImpl(val api: MovieApi): MovieRepository {

    val KEY = "9c4b9deab9d391df1258857ba5f58b9c"

    override suspend fun savePopularMovies(): MutableList<MovieLocalModel> {
        TODO("Not yet implemented")
    }

    override suspend fun saveMovieCast(): MutableList<CastLocal> {
        TODO("Not yet implemented")
    }

    override suspend fun getPopularMovies(): MutableList<MovieLocalModel> {
       return api.getPopularMovies(KEY,1).results.map { it.convertToLocalModel()}.toMutableList() //TODO pages
    }

    override suspend fun getPopularMovieCast(): MutableList<CastLocalModel> {
        return api.getCast(KEY).cast.map { it.convertToLocalModel()}.toMutableList()
    }


}