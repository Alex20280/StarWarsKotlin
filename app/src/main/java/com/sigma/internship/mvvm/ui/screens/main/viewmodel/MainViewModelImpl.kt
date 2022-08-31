package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sigma.internship.mvvm.data.db.convertermodels.Cast
import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.ui.models.cast.CastUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModelImpl(
    private val repository: MovieApiRepository,
    private val dbRepository: MovieDbRepository
) : MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieAndDetailsUi>>()
    override val getMovieAndDetailsById = MutableLiveData<MutableList<MovieAndDetailsUi>>()
    override val getCastById = MutableLiveData<MutableList<CastUi>>()

    override suspend fun saveMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            //dbRepository.saveMovies(repository.getMoviesFromApi().convertToDataBaseModel())
            dbRepository.saveMovies(repository.getMoviesFromApi().results.map { movieResponse ->
                MovieDbModel(
                    movieResponse.id,
                    movieResponse.poster_path,
                    movieResponse.overview,
                    movieResponse.title
                )
            })
        }
    }

    override suspend fun saveDetailsById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val detailsResponse = repository.getMoviesFromApiById(id).convertToDataBaseModel()
            dbRepository.saveDetails(detailsResponse)
        }
    }

    override suspend fun saveCastById(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            //val castResponse = repository.getCastFromApi(id).convertToDataBaseModel()
            val castResponse = repository.getCastFromApi(id).cast.map { castResponse ->
                CastDbModel(
                    id,
                    Cast(castResponse.name, castResponse.profile_path, castResponse.character)
                )
            }
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

    override fun getMovieByIdFromDb(id: Int) {
        viewModelScope.launch {
            val detailsList = dbRepository.getMoviesAndDetailsById(id)
            getMovieAndDetailsById.postValue(detailsList)
        }
    }

    override fun getCastFromDb(id: Int) {
        viewModelScope.launch {
            val castList = dbRepository.getCastById(id)
            //Log.d("some", castList.toString())
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