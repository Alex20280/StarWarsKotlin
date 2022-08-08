package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import kotlinx.coroutines.*

class MainViewModelImpl(private val repository: MovieApiRepository, private val dbRepository: MovieDbRepository) : MainViewModel() {

    override val getMovies = MutableLiveData<List<MovieLocalModel>>()
    override val getCast = MutableLiveData<List<CastLocal>>()


    override suspend fun saveMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            dbRepository.saveMovies(repository.getMoviesFromApi())
        }
    }

    override suspend fun saveMoviesById(id: Int) {
        val castResponse = repository.getMoviesFromApiById(id)
        dbRepository.saveMovieById(castResponse,id)
    }

    override suspend fun saveCastById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getCastFromApi(id)
            dbRepository.saveCast(castResponse,id)

        }
    }

    override suspend fun getAllMoviesFromDb() { //TODO check
        viewModelScope.launch {
            val getMovie = dbRepository.getMovie()
            getMovies.postValue(getMovie)
        }
    }

    override suspend fun getMovieByIdFromDb(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getDetails = dbRepository.getMovieById(id)
            getMovies.postValue(getDetails)
        }
    }

    override suspend fun getCastFromDb(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getSomeCast = dbRepository.getCastById(id)
            getCast.postValue(getSomeCast)
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
