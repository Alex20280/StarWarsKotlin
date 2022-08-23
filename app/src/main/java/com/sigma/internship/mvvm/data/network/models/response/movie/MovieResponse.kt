package com.sigma.internship.mvvm.data.network.models.response.movie

import com.sigma.internship.mvvm.data.db.convertermodels.Genres
import com.sigma.internship.mvvm.data.db.entities.MovieDbModel
import org.koin.core.qualifier.named

data class MovieResponse(
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String)



