package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.entities.ResultDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelImpl(private val repository: MovieApiRepository, private val dbRepository: MovieDbRepository) : MainViewModel() {

    override val getPopularMovies = MutableLiveData<List<ResultDbModel>>()
    override val getMovieDetails = MutableLiveData<List<MovieDbModel>>()
    override val getCast = MutableLiveData<List<MovieWithCastDbModel>>()


    override fun savePopularMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val popularMovieResponse = repository.getMoviesFromApi()
            dbRepository.savePopularMovies(popularMovieResponse)
        }
    }

    override fun saveMovieDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val detailsMovieResponse = repository.getDetailsFromApi(id)
            detailsMovieResponse.map { it }
            dbRepository.saveMoviesDetails(detailsMovieResponse,id)
        }
    }

    override fun saveCast(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getCastFromApi(id)
            dbRepository.saveMovieCast(castResponse,id)

        }
    }

    override fun getPopularMoviesFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            val getMovie = dbRepository.getPopularMovies()
            getPopularMovies.postValue(getMovie)
        }
    }

    override fun getMovieDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getDetails = dbRepository.getMoviesDetails(id)
            getMovieDetails.postValue(getDetails)
        }
    }

    override fun getCast(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val getSomeCast = dbRepository.getMovieCast(id)
            getCast.postValue(getSomeCast)
        }
    }


}


