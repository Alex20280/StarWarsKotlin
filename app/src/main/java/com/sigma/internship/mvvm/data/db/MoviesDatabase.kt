package com.sigma.internship.mvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sigma.internship.mvvm.data.db.dao.MoviesDao
import com.sigma.internship.mvvm.data.db.entities.MovieResponse
import com.sigma.internship.mvvm.data.db.entities.MovieResponseModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCast


@Database(entities = [MovieResponseModel::class, MovieResponse::class, MovieWithCast::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun getMovieDao(): MoviesDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesDatabase? = null
        fun getInstance(context: Context): MoviesDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MoviesDatabase::class.java,
                        "subscriber_data_database"
                    ).build()
                }
                return instance
            }
        }

    }
}