package com.sigma.internship.mvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sigma.internship.mvvm.data.network.models.response.cast.CastAndCrew
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.moviedetails.MovieDuration


@Dao
interface MoviesDao {

    @Query("select * from movie")
    fun getMovieDetails(): LiveData<List<MovieResponseModel>>

    @Insert
    fun addMovieDetails(details: MovieResponseModel)

    @Update
    fun updateDetails(details: MovieResponseModel)

    @Delete
    fun deleteDetails(details: MovieResponseModel)



    @Query("SELECT * FROM movie_duration")
    fun getMovieDuration(): LiveData<List<MovieDuration>>

    @Insert
    fun addMovieDuration(duration: MovieDuration)

    @Update
    fun updateDuration(duration: MovieDuration)

    @Delete
    fun deleteDuration(duration: MovieDuration)



    @Query("SELECT * FROM cast_and_crew")
    fun getCharacterAndActor(): LiveData<List<CastAndCrew>>

    @Insert
    fun addCharacterAndActor(cast: CastAndCrew)

    @Update
    fun updateCharacterAndActor(cast: CastAndCrew)

    @Delete
    fun deleteCharacterAndActor(cast: CastAndCrew)

}