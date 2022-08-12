package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocal
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel

class MovieDbRepositoryIml(private val context: Context): MovieDbRepository {
    override suspend fun saveMovies(response: MovieDbModel) {
        MoviesDatabase.getInstance(context).getMovieDao().insertMovies(response)
    }

    override suspend fun saveMovieById(response: MovieDbModel) {
        MoviesDatabase.getInstance(context).getMovieDao().insertDetails(response)
    }

    override suspend fun saveCast(response: CastDbModel) {
        MoviesDatabase.getInstance(context).getMovieDao().insertCast(response)
    }

    override suspend fun getMovie(): MutableList<MovieLocalModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getMoviesList().map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getMovieById(id: Int):  MutableList<MovieLocalModel> {
        return MoviesDatabase.getInstance(context).getMovieDao().getMovieById(id).map { it.convertToLocalModel() }.toMutableList()
    }

    override suspend fun getCastById(id: Int): MutableList<CastLocal> {
        return MoviesDatabase.getInstance(context).getMovieDao().getAllCastAssociatedWithMovie(id).map { it.castList.get(0).convertToLocalModel() }.toMutableList()
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