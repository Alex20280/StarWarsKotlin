package com.sigma.internship.mvvm.data.repository.movie

import android.util.Log
import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.data.network.Utils
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.details.DetailsResponse
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponse
import com.sigma.internship.mvvm.data.network.models.response.movie.ResultResponseModel

class MovieApiRepositoryImpl(val api: MovieApi): MovieApiRepository {

    override suspend fun getMoviesFromApi(): ResultResponseModel {
        val res = api.getPopularMoviesFromApi(Utils.KEY,1) //TODO pages
        //Log.d("test", res.toString())
        return res
    }

    override suspend fun getMoviesFromApiById(id: Int): DetailsResponse {
        val res = api.getMovieDetailsFromApi(id, Utils.KEY)
        //Log.d("test", res.toString())
        return res
    }

    override suspend fun getCastFromApi(id: Int): CastResponseModel {
        val res = api.getCastFromApi(id, Utils.KEY)
        Log.d("test", res.toString())
        return res
    }


}


/*
override suspend fun getMoviesFromApi(): MutableList<ResultResponseModel> {
    return api.getPopularMoviesFromApi(Utils.KEY,1).results.map { it.convertToLocalModel()}.toMutableList() //TODO pages
    }
        override suspend fun getDetailsFromApi(id: Int): MutableList<ResultResponseModel> {
        return api.getMovieDetailsFromApi(id, Utils.KEY).results.map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getCastFromApi(id: Int): MutableList<CastResponseModel> {
        return api.getCastFromApi(id, Utils.KEY).cast.map { it.convertToLocalModel()}.toMutableList()
    }
*/
