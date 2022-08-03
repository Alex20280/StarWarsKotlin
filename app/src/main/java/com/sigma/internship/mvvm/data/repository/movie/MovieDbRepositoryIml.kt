package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.entities.ResultDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel

class MovieDbRepositoryIml(private val context: Context): MovieDbRepository {
    override suspend fun savePopularMovies(response: MutableList<ResultLocalModel>) {
        MoviesDatabase.getInstance(context).getMovieDao().savePopularMovies(response)
    }

    override suspend fun saveMoviesDetails(response: MutableList<ResultLocalModel>, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().saveMovieDetails(response, id)
    }

    override suspend fun saveMovieCast(response: MutableList<CastLocalModel>, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().saveMovieCast(response, id)
    }


    override suspend fun getPopularMovies(): List<ResultDbModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getPopularMovies()
    }

    override suspend fun getMoviesDetails(id: Int): List<MovieDbModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getMovieDetailsById(id)
    }

    override suspend fun getMovieCast(id: Int): List<MovieWithCastDbModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getCastById(id)
    }


}

