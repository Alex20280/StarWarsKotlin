package com.sigma.internship.mvvm.ui.screens.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sigma.internship.mvvm.data.network.MovieApi
import com.sigma.internship.mvvm.data.network.RetrofitProvider
import com.sigma.internship.mvvm.data.repository.movie.MovieApiRepository
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.PopularLocalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModelImpl(private val repository: MovieApiRepository) : MainViewModel() {

    override val getPopularMovies = MutableLiveData<MutableList<MovieLocalModel>>()
    override val getMovieDetails = MutableLiveData<MutableList<PopularLocalModel>>()
    override val getCast = MutableLiveData<MutableList<CastLocalModel>>()

    val retrofitProvider = RetrofitProvider()
    val quotesApi = retrofitProvider.getInstance().create(MovieApi::class.java)

    override fun savePopularMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val popularMovieResponse = repository.getMoviesFromApi()


            val result = quotesApi.getPopularMoviesFromApi()


            //getPopularMovies.postValue(result)


        }
    }

    override fun saveMovieDetails(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val detailsMovieResponse = repository.getDetailsFromApi(id)
            getMovieDetails.postValue(detailsMovieResponse)
        }
    }

    override fun saveCast(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val castResponse = repository.getCastFromApi(id)
            getCast.postValue(castResponse)

        }
    }
}


/*
    override fun savePopularMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            val popularMovieResponse = repository.savePopularMovies()

            getPopularMovies.postValue(popularMovieResponse)
        }
    }
 */