package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.repository.movie.MovieRepository
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel

class MainViewModelImpl(private val repository: MovieRepository ): MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieLocalModel>>()
    override val getMovieDurationLocalModel = MutableLiveData<MutableList<MovieDurationLocalModel>>()
    override val getCastLocal = MutableLiveData<MutableList<CastLocal>>()


    override fun getPopularMovies() {
        launchWithProgress(isLoading) {
            val populerMovieResponse = repository.getPopularMovies()
            getPopularMovies.postValue(populerMovieResponse)
        }

    }
    override fun getMovieDuration() {
        launchWithProgress(isLoading) {
            val movieDurationResponse = repository.geMovieDuration()
            getMovieDurationLocalModel.postValue(movieDurationResponse)

        }
    }

    override fun getCrewAndCast() {
        launchWithProgress(isLoading) {
            val crewAndCastresponse = repository.getCrewAndCast()
            getCastLocal.postValue(crewAndCastresponse)

        }
    }
}