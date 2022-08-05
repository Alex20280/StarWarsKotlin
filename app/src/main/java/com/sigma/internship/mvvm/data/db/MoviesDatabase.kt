package com.sigma.internship.mvvm.data.db

import android.content.Context
import androidx.room.*
import com.sigma.internship.mvvm.data.db.dao.MoviesDao
import com.sigma.internship.mvvm.data.db.entities.CastDbModel
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import com.sigma.internship.mvvm.data.db.relations.MovieWithCastDbModel


@Database(entities = [MovieDbModel::class, CastDbModel::class, MovieWithCastDbModel::class], version = 1, exportSchema = false)
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