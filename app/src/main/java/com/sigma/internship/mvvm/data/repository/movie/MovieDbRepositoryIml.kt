package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MovieDbRepositoryIml(private val context: Context): MovieDbRepository {
    override suspend fun saveMovies(response: MovieResponseModel) {
        MoviesDatabase.getInstance(context).getMovieDao().insertMovies(response)
    }

    override suspend fun saveMovieById(response: MovieResponseModel, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().insertDetails(response, id)
    }

    override suspend fun saveCast(response: CastResponseModel, id: Int) {
        MoviesDatabase.getInstance(context).getMovieDao().insertCast(response, id)
    }


    override suspend fun getMovie(): List<MovieLocalModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getMoviesList().map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getMovieById(id: Int):  MutableList<MovieLocalModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getMovieById(id).map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getCastById(id: Int): MutableList<CastLocal> {
        return MoviesDatabase.getInstance(context).getMovieDao().getAllCastAssociatedWithMovie(id)
        //return MoviesDatabase.getInstance(context).getMovieDao().getCastById(id).map { it.convertToLocalModel() }.toMutableList()
    }


}


//override suspend fun saveMovies(response: MutableList<MovieResponseModel>) {
//    MoviesDatabase.getInstance(context).getMovieDao().saveMovies(response)
//}
//
//override suspend fun saveMoviesDetails(response: MutableList<MovieResponseModel>, id: Int) {
//    MoviesDatabase.getInstance(context).getMovieDao().saveMovies(response, id)
//}
//
//override suspend fun saveCast(response: MutableList<CastResponse>, id: Int) {
//    MoviesDatabase.getInstance(context).getMovieDao().saveCast(response, id)
//}
//
//
//override suspend fun getMovie(): List<ResultDbModel> {
//    return MoviesDatabase.getInstance(context).getMovieDao().getPopularMovies()
//}
//
//override suspend fun getMovieById(id: Int): List<MovieDbModel> {
//    return MoviesDatabase.getInstance(context).getMovieDao().getMovieById(id)
//}
//
//override suspend fun getCast(id: Int): List<MovieWithCastDbModel> {
//    return MoviesDatabase.getInstance(context).getMovieDao().getCastById(id)
//}