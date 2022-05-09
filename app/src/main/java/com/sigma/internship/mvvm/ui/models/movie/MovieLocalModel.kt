package com.sigma.internship.mvvm.ui.models.movie

data class MovieLocalModel(
    val posterPath: String,
    val overview: String,
    val title: String,
    val genreIds: ArrayList<Int>
    )
