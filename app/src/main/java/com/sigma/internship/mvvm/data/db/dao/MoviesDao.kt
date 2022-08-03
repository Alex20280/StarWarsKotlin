package com.sigma.internship.mvvm.data.db.dao

import androidx.room.*
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.entities.ResultDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel
import com.sigma.internship.mvvm.data.network.models.response.cast.CastResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.ui.models.cast.CastLocalModel
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.popular.ResultLocalModel


@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovies (response: MutableList<ResultLocalModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieDetails (response: MutableList<ResultLocalModel>, id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovieCast (response: MutableList<CastLocalModel>, id: Int)



    @Query("select * FROM response")
    suspend fun getPopularMovies(): List<ResultDbModel>

    @Query("select * FROM movie")
    suspend fun getMovieDetailsById(id: Int): List<MovieDbModel>

    @Transaction
    @Query ("SELECT * FROM movie_cast")
    suspend fun getCastById(id: Int) : List<MovieWithCastDbModel>

}