package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

/*
 * Save and get data from Room db
 */

interface MovieDbRepository {


    suspend fun saveMovies (response: MovieResponseModel)

    suspend fun saveMovieById (response: MovieResponseModel, id: Int)

    suspend fun saveCast (response: CastResponseModel, id: Int)

    suspend fun getMovie(): MutableList<MovieLocalModel>

    suspend fun getMovieById(id: Int): MutableList<MovieLocalModel>

    suspend fun getCastById(id: Int): MutableList<CastLocal>

}

/*
suspend fun saveMovies (response: MutableList<ResultLocalModel>)

suspend fun saveMoviesDetails (response: MutableList<ResultLocalModel>, id: Int)

suspend fun saveCast (response: MutableList<CastLocalModel>, id: Int)

suspend fun getMovie(): List<MovieDbModel>

suspend fun getMovieById(id: Int): List<MovieDbModel>

suspend fun getCast(id: Int): List<CastDbModel>*/
