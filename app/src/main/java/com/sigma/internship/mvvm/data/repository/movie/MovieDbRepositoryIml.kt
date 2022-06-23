package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import androidx.lifecycle.LiveData
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.db.entities.Cast
import com.sigma.internship.mvvm.data.db.entities.CastModel
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.entities.MovieResponseModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCast
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.PopularLocalModel

class MovieDbRepositoryIml: MovieDbRepository {

    lateinit var context: Context  //TODO check

    override suspend fun savePopularMovies(response: MovieResponseModel) {
        MoviesDatabase.getInstance(context).getMovieDao().savePopularMovies(response)
    }

    override suspend fun saveMoviesDetails(response: MovieResponse, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().saveMovieDetails(response, id)
    }

    override suspend fun saveMovieCast(response: CastModel, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().saveMovieCast(response, id)
    }

    override suspend fun getPopularMovies(): LiveData<List<MovieResponseModel>> {
        return MoviesDatabase.getInstance(context).getMovieDao().getPopularMovies()
    }

    override suspend fun getMoviesDetails(id: Int): LiveData<List<MovieResponse>> {
        return MoviesDatabase.getInstance().getMovieDao().getMovieDetailsById()
    }

    override suspend fun getMovieCast(id: Int): LiveData<List<MovieWithCast>> {
        TODO("Not yet implemented")
    }


}
