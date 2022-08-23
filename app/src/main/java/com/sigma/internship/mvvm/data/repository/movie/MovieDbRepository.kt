package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.ui.models.cast.CastUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi

/*
 * Save and get data from Room db
 */

interface MovieDbRepository {


    suspend fun saveMovies (response: MovieDbModel)

    suspend fun saveDetails (response: DetailsDbModel)

    suspend fun saveCast (response: CastDbModel)

    suspend fun getPopularMoviesList() : MutableList<MovieAndDetailsUi>

    suspend fun getMoviesAndDetailsById(id: Int): MutableList<MovieAndDetailsUi>

    suspend fun getCastById(id: Int): MutableList<CastUi>

}

/*
suspend fun saveMovies (response: MutableList<ResultLocalModel>)

suspend fun saveMoviesDetails (response: MutableList<ResultLocalModel>, id: Int)

suspend fun saveCast (response: MutableList<CastLocalModel>, id: Int)

suspend fun getMovie(): List<MovieDbModel>

suspend fun getMovieById(id: Int): List<MovieDbModel>

suspend fun getCast(id: Int): List<CastDbModel>*/
