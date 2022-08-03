package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel

//https://peaku.co/questions/20052-como-resolver-%26quot;las-entidades-y-los-pojo-deben-tener-un-constructor-publico-utilizable%26quot;

data class Results(
        @Embedded
        var results: MovieDbModel
)

// val results: ArrayList<MovieDbModel> = arrayListOf()