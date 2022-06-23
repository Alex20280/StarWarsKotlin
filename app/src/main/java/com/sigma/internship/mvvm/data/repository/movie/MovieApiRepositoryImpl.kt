package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.data.network.Utils
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.PopularLocalModel
import kotlin.coroutines.coroutineContext

class MovieApiRepositoryImpl(val api: MovieApi): MovieApiRepository {

    override suspend fun getMoviesFromApi(): MutableList<MovieLocalModel> {
       return api.getPopularMoviesFromApi(Utils.KEY,1).results.map { it.convertToLocalModel()}.toMutableList() //TODO pages
    }

    override suspend fun getDetailsFromApi(id: Int): MutableList<PopularLocalModel> {
        return api.getMovieDetailsFromApi(id, Utils.KEY).genres.map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getCastFromApi(id: Int): MutableList<CastLocalModel> {
        return api.getCastFromApi(id, Utils.KEY).cast.map { it.convertToLocalModel()}
    }


}

/*
    override suspend fun savePopularMovies(): MutableList<MovieLocalModel> {
       return api.getPopularMoviesFromApi(Utils.KEY,1).results.map { it.convertToLocalModel()}.toMutableList() //TODO pages
    }
 */