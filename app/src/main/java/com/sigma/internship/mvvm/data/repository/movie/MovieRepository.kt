package com.sigma.internship.mvvm.data.repository.movie

import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.data.network.models.response.cast.CastAndCrew
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel


interface MovieRepository {

    suspend fun getPopularMovies(): MutableList<MovieLocalModel>

    suspend fun geMovieDuration(): MutableList<MovieDurationLocalModel>

    suspend fun getCrewAndCast(): MutableList<CastAndCrew>

}