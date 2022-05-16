package com.sigma.internship.mvvm.data.network

import com.sigma.internship.mvvm.data.network.models.response.cast.CastAndCrew
import com.sigma.internship.mvvm.data.network.models.response.moviedetails.MovieDuration
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String?): PopularResponseModel

    @GET("/movie/{movie_id}")
    suspend fun getMovieDuration(@Query("api_key") apiKey: String?): MovieDuration

    @GET("/movie/{movie_id}/credits")
    suspend fun getCrewAndCast(@Query("api_key") apiKey: String?): CastAndCrew

}