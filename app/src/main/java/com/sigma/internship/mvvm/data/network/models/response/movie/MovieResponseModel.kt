package com.sigma.internship.mvvm.data.network.models.response.movie

data class MovieResponseModel(
    val id: Int,
    val poster_path: String,
    val overview: String,
    val original_title: String,
    val genres: ArrayList<Int>,
    val runtime: Int)

