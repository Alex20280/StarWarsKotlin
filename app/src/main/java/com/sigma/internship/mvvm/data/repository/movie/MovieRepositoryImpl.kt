package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

class MovieRepositoryImpl(val api: MovieApi): MovieRepository {

    val KEY = "9c4b9deab9d391df1258857ba5f58b9c"

    override suspend fun getPopularMovies(): MutableList<MovieLocalModel> {
       return api.getPopularMovies(KEY).results.map { it.convertToLocalModel()}.toMutableList()
    }

    override suspend fun geMovieDuration(): MutableList<MovieDurationLocalModel> {
        return api.getMovieDuration(KEY).convertToLocalModel().runtime.toMutableList()<Int>
    }

    override suspend fun getCast(): MutableList<CastLocal> {
        return api.getCrewAndCast(KEY).map { it.convertToLocalModel()}.toMutableList()
    }


}