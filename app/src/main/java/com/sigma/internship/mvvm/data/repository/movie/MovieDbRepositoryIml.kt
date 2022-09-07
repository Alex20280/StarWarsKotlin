package com.sigma.internship.mvvm.data.repository.movie

import android.content.Context
import android.util.Log
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.ui.models.cast.CastUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi

class MovieDbRepositoryIml(private val context: Context) : MovieDbRepository {

    override suspend fun saveMovies(response: List <MovieDbModel>) {
        MoviesDatabase.getInstance(context).getMovieDao().insertMovies(response)
    }

    override suspend fun saveDetails(response: DetailsDbModel) {
        MoviesDatabase.getInstance(context).getMovieDao().insertDetails(response)
    }

    override suspend fun saveCast(response: List<CastDbModel>) {
        MoviesDatabase.getInstance(context).getMovieDao().insertCast(response)
    }

    override suspend fun getPopularMoviesList(): MutableList<MovieAndDetailsUi> {
        val movie = MoviesDatabase.getInstance(context).getMovieDao().getPopularMovies().toMutableList()
        val details = MoviesDatabase.getInstance(context).getMovieDao().getPopularDetails().toMutableList()
        val zipData = movie.zip(details) { movie, detail -> Pair(movie, detail) }
        val mappedData = zipData.map { pair -> MovieAndDetailsUi.fromDatabaseEntities(pair.first, pair.second) }.toMutableList()
        return mappedData
    }

    override suspend fun getMoviesAndDetailsById(id: Int): MutableList<MovieAndDetailsUi> {
        val movie = MoviesDatabase.getInstance(context).getMovieDao().getMovieListById(id).toMutableList()
        val details = MoviesDatabase.getInstance(context).getMovieDao().getDetailsListById(id).toMutableList()
        val zipData = movie.zip(details) { movie, detail -> Pair(movie, detail) }
        val mappedData = zipData.map { pair -> MovieAndDetailsUi.fromDatabaseEntities(pair.first, pair.second) }.toMutableList()
        return mappedData
    }

    override suspend fun getCastById(id: Int): MutableList<CastUi> {
        val list = mutableListOf<CastUi>()
        val cast = MoviesDatabase.getInstance(context).getMovieDao().getAllCastAssociatedWithMovie(id)
        Log.d("res", cast.toString())
        cast.map {
            list.add(CastUi(it.cast.name, it.cast.profile_path, it.cast.character))
        }
        return list
    }

/*    override suspend fun getCastById(id: Int): MutableList <CastUi> {
        val cast = MoviesDatabase.getInstance(context).getMovieDao().getAllCastAssociatedWithMovie(id)
        val res = cast.map { it.castList.get(0) }.toMutableList().get(0).convertToLocalModel().cast.toMutableList()
        return res
    }*/


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


//return MoviesDatabase.getInstance(context).getMovieDao().getMovieAndDetailsList(id).map { it.details.convertToLocalModel() }.toMutableList()