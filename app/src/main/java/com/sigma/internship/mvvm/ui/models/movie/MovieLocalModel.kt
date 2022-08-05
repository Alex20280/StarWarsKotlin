package com.sigma.internship.mvvm.ui.models.movie

import com.sigma.internship.mvvm.data.db.convertermodels.Genres

data class MovieLocalModel(
    val page: Int,
    val id: Int,
    val poster_path: String,
    val overview: String,
    val title: String,
    val genre_ids: Genres,
    val runtime: Int
    )
