package com.sigma.internship.mvvm.data.db.dao

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies (movieList: List <MovieDbModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails (movies: DetailsDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCast (cast: List <CastDbModel>)


    @Transaction
    @Query("select * FROM movie")
    suspend fun getPopularMovies(): List<MovieDbModel>

    @Transaction
    @Query("select * FROM details")
    suspend fun getPopularDetails(): List<DetailsDbModel>

    @Transaction
    @Query("select * FROM movie WHERE id = :id")
    suspend fun getMovieListById(id: Int): List<MovieDbModel>

    @Transaction
    @Query("select * FROM details WHERE id = :id")
    suspend fun getDetailsListById(id: Int): List<DetailsDbModel>

    @Transaction
    @Query("select * FROM `cast` WHERE id = :id")
    fun getAllCastAssociatedWithMovie(id: Int): List<CastDbModel>

}
