package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

/*
 * Save and get data from Room db
 */

interface MovieDbRepository {


    suspend fun saveMovies (response: MovieDbModel)

    suspend fun saveMovieById (response: MovieDbModel)

    suspend fun saveCast (response: CastDbModel)

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
