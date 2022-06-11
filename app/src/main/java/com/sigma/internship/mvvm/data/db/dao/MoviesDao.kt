package com.sigma.internship.mvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.Cast
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.relations.MovieWithCast


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovies (details: MovieResponse)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieCast (cast: Cast) //??

    @Query("select * FROM movie")
    suspend fun getPopularMovieById(): LiveData<List<MovieResponse>>

    @Transaction
    @Query ("SELECT * FROM movie_cast")
    suspend fun getMovieAndCastById() : LiveData<List<MovieWithCast>>

}