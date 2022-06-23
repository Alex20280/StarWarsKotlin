package com.sigma.internship.mvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastModel
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.entities.MovieResponseModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCast


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovies (response: MovieResponseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetails (response: MovieResponse, id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieCast (response: CastModel, id: Int)



    @Query("select * FROM response")
    suspend fun getPopularMovies(): LiveData<List<MovieResponseModel>>

    @Query("select * FROM movie")
    suspend fun getMovieDetailsById(id: Int): LiveData<List<MovieResponse>>

    @Transaction
    @Query ("SELECT * FROM movie_cast")
    suspend fun getCastById(id: Int) : LiveData<List<MovieWithCast>>

}