package com.sigma.internship.mvvm.data.db.dao

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithListOfCast


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies (movies: MovieDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails (movies: MovieDbModel, id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCast (cast: CastDbModel, id: Int)



    @Transaction
    @Query("select * FROM movie")
    suspend fun getMoviesList(): List<MovieDbModel>

    @Transaction
    @Query("select * FROM movie WHERE id = :id")
    suspend fun getMovieById(id: Int): List<MovieDbModel>

    @Transaction
    @Query("SELECT * FROM movie WHERE id = :movie")
    fun getAllCastAssociatedWithMovie(movie: Int): List<MovieWithListOfCast>
}


/*
@Transaction
@Query("SELECT * FROM movie WHERE id = :movie")
fun getAllCastAssociatedWithMovie(movie: MovieDbModel): List<MovieWithListOfCast>*/
