package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.repository.movie.MovieRepository
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MainViewModelImpl(private val repository: MovieRepository): MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieLocalModel>>()
    override val getCast = MutableLiveData<MutableList<CastLocalModel>>()


    override fun getPopularMovies() {
        launchWithProgress(isLoading) {
            val popularMovieResponse = repository.getPopularMovies()
            getPopularMovies.postValue(popularMovieResponse)
        }

    }

    override fun getCast() {
        launchWithProgress(isLoading) {
            val crewAndCastresponse = repository.getPopularMovieCast()
            getCast.postValue(crewAndCastresponse)

        }
    }
}