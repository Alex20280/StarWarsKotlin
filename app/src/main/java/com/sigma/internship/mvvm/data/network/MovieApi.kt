package com.sigma.internship.mvvm.data.network

import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.details.DetailsResponse
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMoviesFromApi(@Query("api_key") apiKey: String?, @Query ("page") page: Int): MovieResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailsFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): DetailsResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getCastFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): CastResponseModel

}


/*
@GET("movie/popular")
suspend fun getPopularMoviesFromApi(@Query("api_key") apiKey: String?, @Query ("page") page: Int): MovieResponseModel

@GET("movie/{movie_id}")
suspend fun getMovieDetailsFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): MutableList<MovieResponseModel>

@GET("movie/{movie_id}/credits")
suspend fun getCastFromApi(@Path("movie_id") movieId: Int, @Query("api_key") apiKey: String?): MutableList<CastResponse>*/
