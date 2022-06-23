package com.sigma.internship.mvvm.data.network

import com.sigma.internship.mvvm.data.network.models.response.cast.Cast
import com.sigma.internship.mvvm.data.network.models.response.cast.CastModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMoviesFromApi(@Query("api_key") apiKey: String?, @Query ("page") page: Int): PopularResponseModel

    @GET("/movie/{movie_id}")
     fun getMovieDetailsFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): MovieResponseModel

    @GET("/movie/{movie_id}/credits")
    suspend fun getCastFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?):CastModel

}