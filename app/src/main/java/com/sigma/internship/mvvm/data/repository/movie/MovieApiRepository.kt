package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.PopularLocalModel

/*
 * Get data from API
 */

interface MovieApiRepository {

    suspend fun getMoviesFromApi(): MutableList<MovieLocalModel>

    suspend fun getDetailsFromApi(id: Int): MutableList<PopularLocalModel>

    suspend fun getCastFromApi(id: Int): MutableList<CastLocalModel>

}