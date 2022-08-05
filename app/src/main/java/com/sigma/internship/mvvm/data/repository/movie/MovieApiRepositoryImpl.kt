package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.data.network.Utils
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponse
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel

class MovieApiRepositoryImpl(val api: MovieApi): MovieApiRepository {

    override suspend fun getMoviesFromApi(): MovieResponseModel {
       return api.getPopularMoviesFromApi(Utils.KEY,1)
    }

    override suspend fun getMoviesFromApiById(id: Int): MovieResponseModel {
        return api.getMovieDetailsFromApi(id, Utils.KEY)
    }

    override suspend fun getCastFromApi(id: Int): CastResponseModel {
        return api.getCastFromApi(id, Utils.KEY)
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
