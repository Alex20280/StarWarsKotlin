package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.map
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.data.repository.movie.MovieDbRepository
import com.sigma.internship.mvvm.databinding.ActivityStarMovieBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.screens.main.adapters.MoviesRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class StarMovieActivity : BaseActivity<MainViewModel>() {

    private val movieAdapter = MoviesRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null
    //lateinit var movieList: ArrayList<MovieLocalModel> //!lateinit var movieList: ArrayList<ResultResponseModel>


    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityStarMovieBinding by lazy { ActivityStarMovieBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        CoroutineScope(Dispatchers.IO).launch {
            saveMovies()
            saveMovieRuntime()
            saveCast()
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = binding.activityMainRecyclerView
        movieAdapter.setHasStableIds(true)
        val snap = LinearSnapHelper()
        recyclerView.adapter = movieAdapter
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        snap.attachToRecyclerView(recyclerView)
    }

    private suspend fun saveMovies() {
        viewModel.saveMovies()
    }

    private suspend fun saveMovieRuntime() {
        //val list = viewModel.getMovies.value
        val movieList = viewModel.getMovieList()
        val movieId = movieList.map { it.id }
        movieId.forEach {
            viewModel.saveMoviesById(it)
        }
    }

    private suspend fun saveCast() {
        val movieList = viewModel.getMovieList()
        val movieId = movieList.map { it.id }
        movieId.forEach {
            viewModel.saveCastById(it)
        }
    }

    private fun getMovieFromDb() {
        viewModel.getMovies
    }



    override fun liveDataObserver() {
        getMovieFromDb()

        viewModel.getMovies.observe(this, {list ->
            list.let {
                movieAdapter.setSomeList(it)
            }
            //Log.d("title", it.first().title)
        })
/*        viewModel.getCast.observe(this, {
            Log.d("111", it.get(1).name)
        })
        viewModel.getPopularMovies.observe(this,{
            Log.d("111", it.first().results.get(1).title)
        })*/
    }
}





/*
private suspend fun saveMovieRuntime() {
    val movieId = movieList.map { it.id }
    movieId.forEach {
        viewModel.saveMoviesById(it)
    }
}

private suspend fun saveCast() {
    val movieId = movieList.map { it.id }
    movieId.forEach {
        viewModel.saveCastById(it)
    }
}*/
