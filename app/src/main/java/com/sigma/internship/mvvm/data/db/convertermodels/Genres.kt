package com.sigma.internship.mvvm.data.db.convertermodels

import androidx.room.Embedded

data class Genres(
    @Embedded
    val id: Int,
    val name: String

)

//  val genre_ids: ArrayList<Int> = arrayListOf()
