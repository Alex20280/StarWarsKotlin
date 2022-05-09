package com.sigma.internship.mvvm.data.network

import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    /*
    @GET("/latest")
    suspend fun getLatestList(@Query("page") page: Int): LatestResponseModel
    */

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String?): PopularResponseModel

}