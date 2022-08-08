package com.sigma.internship.mvvm.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithListOfCast
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies (movies: MovieResponseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails (movies: MovieResponseModel, id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCast (cast: CastResponseModel, id: Int)



    @Transaction
    @Query("select * FROM movie")
    suspend fun getMoviesList(): List<MovieDbModel>

    @Transaction
    @Query("select * FROM movie WHERE id = :id")
    suspend fun getMovieById(id: Int): List<MovieDbModel>

    @Transaction
    @Query("SELECT * FROM 'cast' WHERE id = :movie")
    fun getAllCastAssociatedWithMovie(movie: Int): List<MovieWithListOfCast>
}


/*
@Transaction
@Query("SELECT * FROM movie WHERE id = :movie")
fun getAllCastAssociatedWithMovie(movie: MovieDbModel): List<MovieWithListOfCast>*/
