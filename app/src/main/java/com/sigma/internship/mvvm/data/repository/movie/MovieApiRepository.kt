package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponse
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel

/*
 * Get data from API
 */

interface MovieApiRepository {

    suspend fun getMoviesFromApi(): MutableList<ResultLocalModel>

    suspend fun getDetailsFromApi(id: Int):  MutableList<ResultLocalModel>

    suspend fun getCastFromApi(id: Int): MutableList<CastLocalModel>

}