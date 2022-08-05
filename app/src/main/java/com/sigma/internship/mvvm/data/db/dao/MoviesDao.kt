package com.sigma.internship.mvvm.data.db.dao

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies (movies: MovieResponseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDetailsById (movies: MovieResponseModel, id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCast (cast: CastResponseModel, id: Int)

    @Transaction
    @Query("select * FROM movie")
    suspend fun getMoviesList(): List<MovieDbModel>

    @Transaction
    @Query("select * FROM movie")
    suspend fun getMovieById(id: Int): List<MovieDbModel>

    @Transaction
    @Query ("SELECT * FROM movie_cast")
    suspend fun getCastById(id: Int) : List<CastDbModel>

}