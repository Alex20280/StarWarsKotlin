package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.ui.models.cast.CastAndCrewLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

class MovieRepositoryImpl(val api: MovieApi): MovieRepository {

    val key = "9c4b9deab9d391df1258857ba5f58b9c"

    override suspend fun getPopularMovies(): MutableList<MovieLocalModel> {
       return api.getPopularMovies(key).results.map { it.convertToLocalModel()}.toMutableList()
    }

    override suspend fun geMovieDuration(): MutableList<MovieDurationLocalModel> {
        return api.getMovieDuration(key).runtime.. {it.convertToLocalModel()}.toMutableList()
    }

    override suspend fun getCrewAndCast(): MutableList<CastAndCrewLocalModel> {
        return api.getCrewAndCast(key).character.
        return api.getCrewAndCast(key).map { it.convertToLocalModel()}.toMutableList()
    }


}