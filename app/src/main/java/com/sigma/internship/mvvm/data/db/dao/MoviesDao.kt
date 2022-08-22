package com.sigma.internship.mvvm.data.db.dao

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.DetailsDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithListOfCast


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies (movies: MovieDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails (movies: DetailsDbModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCast (cast: CastDbModel)


    @Transaction
    @Query("select * FROM movie WHERE id = :id")
    suspend fun getMovieListById(id: Int): List<MovieDbModel>

    @Transaction
    @Query("select * FROM details WHERE id = :id")
    suspend fun getDetailsListById(id: Int): List<DetailsDbModel>

    @Transaction
    @Query("SELECT * FROM movie WHERE id = :movie")
    fun getAllCastAssociatedWithMovie(movie: Int): List<MovieWithListOfCast>
}


/*
@Transaction
@Query("SELECT * FROM movie WHERE id = :movie")
fun getAllCastAssociatedWithMovie(movie: MovieDbModel): List<MovieWithListOfCast>*/
