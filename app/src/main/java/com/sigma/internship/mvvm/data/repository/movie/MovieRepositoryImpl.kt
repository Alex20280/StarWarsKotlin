package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.network.MovieAPI
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MovieRepositoryImpl(val api: MovieAPI): MovieRepository {

    val key = "9c4b9deab9d391df1258857ba5f58b9c"

    override suspend fun getPopularMovies(): MutableList<MovieLocalModel> {
       return api.getPopularMovies(key).results.map { it.convertToLocalModel()}.toMutableList()
    }


}