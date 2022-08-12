package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.details.DetailsResponse
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponse

/*
 * Get data from API
 */

interface MovieApiRepository {

    suspend fun getMoviesFromApi(): MovieResponse

    suspend fun getMoviesFromApiById(id: Int): DetailsResponse

    suspend fun getCastFromApi(id: Int): CastResponseModel

}



/*
suspend fun getMoviesFromApi(): MovieResponseModel

suspend fun getMoviesFromApiById(id: Int): MovieResponseModel

suspend fun getCastFromApi(id: Int): MutableList<CastResponse>*/
