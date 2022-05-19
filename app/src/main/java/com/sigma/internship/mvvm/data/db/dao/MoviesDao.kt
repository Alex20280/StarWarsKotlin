package com.sigma.internship.mvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.entities.Cast
import com.sigma.internship.mvvm.data.db.entities.MovieDuration


@Dao
interface MoviesDao {

    @Insert  (onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDetails(details: MovieResponse)

    @Query("select * FROM movie")
    fun getMovieDetails(): LiveData<List<MovieResponse>>

    @Query("SELECT * FROM movie WHERE movie_id ==:movie_id")
    fun getExactMovieDetails(movie_id: Int)

    @Update (onConflict = OnConflictStrategy.REPLACE)
    fun updateDetails(details: MovieResponse)



    @Insert  (onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieDuration(duration: MovieDuration)

    @Query("SELECT * FROM movie_duration")
    fun getMovieDuration(): LiveData<List<MovieDuration>>

    @Query("SELECT * FROM movie_duration WHERE movie_id ==:movie_id")
    fun getExactMovieDuration(movie_id: Int)

    @Update  (onConflict = OnConflictStrategy.REPLACE)
    fun updateDuration(duration: MovieDuration)


    @Insert  (onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacterAndActor(cast: Cast)

    @Query("SELECT * FROM `cast` WHERE movie_id ==:movie_id")
    fun getExactMovieCharacterAndActor(movie_id: Int)

    @Update  (onConflict = OnConflictStrategy.REPLACE)
    fun updateCharacterAndActor(cast: Cast)


}