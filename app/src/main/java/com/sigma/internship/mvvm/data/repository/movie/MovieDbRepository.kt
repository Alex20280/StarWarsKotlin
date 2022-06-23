package com.sigma.internship.mvvm.data.repository.movie

import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.data.db.entities.Cast
import com.sigma.internship.mvvm.data.db.entities.CastModel
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.entities.MovieResponseModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCast

/*
 * Save and get data from Room db
 */

interface MovieDbRepository {

    suspend fun savePopularMovies (response: MovieResponseModel)

    suspend fun saveMoviesDetails (response: MovieResponse, id: Int)

    suspend fun saveMovieCast (response: CastModel, id: Int)

    suspend fun getPopularMovies(): LiveData<List<MovieResponseModel>>

    suspend fun getMoviesDetails(id: Int): LiveData<List<MovieResponse>>

    suspend fun getMovieCast(id: Int): LiveData<List<MovieWithCast>>


}