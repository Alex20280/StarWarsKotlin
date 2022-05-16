package com.sigma.internship.mvvm.ui.screens.main

object Utils {
    val CONSTANT_MAP: HashMap<Int?, String?> = object : HashMap<Int?, String?>() {
        init {
            put(28, "Action")
            put(12, "Adventure")
            put(16, "Animation")
            put(35, "Comedy")
            put(80, "Crime")
            put(99, "Documentary")
            put(18, "Drama")
            put(10751, "Family")
            put(14, "Fantasy")
            put(36, "History")
            put(27, "Horror")
            put(10402, "Music")
            put(9648, "Mystery")
            put(10749, "Romance")
            put(878, "Science Fiction")
            put(10770, "TV Movie")
            put(53, "Thriller")
            put(10752, "War")
            put(37, "Western")
        }
    }

    fun getGenre(ids: List<Int?>, genreById: Map<Int?, String?>): String? {
        val result: MutableList<String?> = ArrayList()
        for (id in ids) {
            if (genreById.containsKey(id)) result.add(genreById[id])
        }
        return result[0]
    }

    fun getGenreList(ids: List<Int?>, genreById: Map<Int?, String?>): List<String?>? {
        val result: MutableList<String?> = ArrayList()
        for (id in ids) {
            if (genreById.containsKey(id)) result.add(genreById[id])
        }
        return result
    }

}