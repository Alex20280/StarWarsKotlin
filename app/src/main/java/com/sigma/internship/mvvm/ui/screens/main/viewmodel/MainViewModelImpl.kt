package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import kotlinx.coroutines.*

class MainViewModelImpl(private val repository: MovieApiRepository, private val dbRepository: MovieDbRepository) : MainViewModel() {

    override val getMovies = MutableLiveData<MutableList<MovieLocalModel>>()
    override val getCast = MutableLiveData<MutableList<CastLocal>>()


    override suspend fun saveMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            dbRepository.saveMovies(repository.getMoviesFromApi().convertToDataBaseModel())
        }
    }

    override suspend fun saveMoviesById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getMoviesFromApiById(id).convertToDataBaseModel()
            dbRepository.saveMovieById(castResponse)
        }
    }

    override suspend fun saveCastById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getCastFromApi(id).convertToDataBaseModel()
            dbRepository.saveCast(castResponse)

        }
    }

    override suspend fun getAllMoviesFromDb() { //TODO check
        viewModelScope.launch {
            val movieList = dbRepository.getMovie()
            getMovies.postValue(movieList)
        }
    }

    override suspend fun getMovieList(): List<MovieLocalModel>{
        val deferredlist = viewModelScope.async {
            dbRepository.getMovie().toList()
        }
        val movieList = deferredlist.await()
        return movieList


    }

    override suspend fun getMovieByIdFromDb(id: Int) {
        viewModelScope.launch {
            val detailsList = dbRepository.getMovieById(id)
            getMovies.postValue(detailsList)
        }
    }

    override suspend fun getCastFromDb(id: Int) {
        viewModelScope.launch {
            val castList = dbRepository.getCastById(id)
            getCast.postValue(castList)
        }
    }


}


/*
override fun saveMovies() {
    CoroutineScope(Dispatchers.IO).launch {
        val popularMovieResponse = repository.getMoviesFromApi()
        dbRepository.saveMovies(popularMovieResponse)
    }
}*/
