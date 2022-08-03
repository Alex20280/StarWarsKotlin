package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.entities.ResultDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel

/*
 * Save and get data from Room db
 */

interface MovieDbRepository {


    suspend fun savePopularMovies (response: MutableList<ResultLocalModel>)

    suspend fun saveMoviesDetails (response: MutableList<ResultLocalModel>, id: Int)

    suspend fun saveMovieCast (response: MutableList<CastLocalModel>, id: Int)

    suspend fun getPopularMovies(): List<ResultDbModel>

    suspend fun getMoviesDetails(id: Int): List<MovieDbModel>

    suspend fun getMovieCast(id: Int): List<MovieWithCastDbModel>

}