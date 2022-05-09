package com.sigma.internship.mvvm.ui.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.db.dao.UsersDao
import com.sigma.internship.mvvm.data.db.entities.UserEntity
import com.sigma.internship.mvvm.data.entities.UserLocalModel
import com.sigma.internship.mvvm.data.repository.movie.MovieRepository
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MainViewModelImpl(private val repository: MovieRepository): MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieLocalModel>>()


    override fun getPopularMovies() {
        launchWithProgress(isLoading){
            val response = repository.getPopularMovies()
            getPopularMovies.postValue(response)
        }

    }

}