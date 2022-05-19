package com.sigma.internship.mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sigma.internship.mvvm.data.db.dao.MoviesDao
import com.sigma.internship.mvvm.data.network.models.response.cast.Cast
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.moviedetails.MovieDuration

@Database(entities = [MovieResponseModel::class, MovieDuration::class, Cast::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun getMovieDetailsDao(): MoviesDao

    abstract fun getMovieDurationDao(): MoviesDao

    abstract fun getCastAndCrewDao(): MoviesDao

}