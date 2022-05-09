package com.sigma.internship.mvvm.data.repository.movie

import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

interface MovieRepository {

    suspend fun getPopularMovies(): MutableList<MovieLocalModel>
}