package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.ui.models.cast.CastUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModelImpl(private val repository: MovieApiRepository, private val dbRepository: MovieDbRepository) : MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieAndDetailsUi>>()
    override val getMovieAndDetailsById = MutableLiveData<MutableList<MovieAndDetailsUi>>()
    override val getCastById = MutableLiveData<MutableList<CastUi>>()

    override suspend fun saveMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            dbRepository.saveMovies(repository.getMoviesFromApi().convertToDataBaseModel())
        }
    }

    override suspend fun saveDetailsById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getMoviesFromApiById(id).convertToDataBaseModel()
            dbRepository.saveDetails(castResponse)
        }
    }

    override suspend fun saveCastById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getCastFromApi(id).convertToDataBaseModel()
            dbRepository.saveCast(castResponse)

        }
    }

    override suspend fun getMovieIds(): List<Int> {
        val listOfIds = viewModelScope.async {
            repository.getMoviesFromApi().results.map { it.id }
        }
        return listOfIds.await()
    }

    override fun getPopularMovies() {
        viewModelScope.launch {
            val popular = dbRepository.getPopularMoviesList()
            //Log.d("test", popular.toString())
            getPopularMovies.postValue(popular)
        }
    }

    override suspend fun getMovieByIdFromDb(id: Int){
        viewModelScope.launch {
            val detailsList = dbRepository.getMoviesAndDetailsById(id)
            getMovieAndDetailsById.postValue(detailsList)
        }
    }

    override suspend fun getCastFromDb(id: Int) {
        viewModelScope.launch {
            val castList = dbRepository.getCastById(id)
            getCastById.postValue(castList)
        }
    }


}


/*
override fun saveMovies() {
    CoroutineScope(Dispatchers.IO).launch {
        val popularMovieResponse = repository.getMoviesFromApi()
        dbRepository.saveMovies(popularMovieResponse)
    }
}


override suspend fun getMovieList(): List<MovieLocalModel>{
    val deferredlist = viewModelScope.async {
        dbRepository.getMovie().toList()
    }
    val movieList = deferredlist.await()
    return movieList


}
*/