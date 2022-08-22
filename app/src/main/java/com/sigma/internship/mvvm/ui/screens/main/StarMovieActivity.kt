package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.databinding.ActivityStarMovieBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.adapters.MoviesRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class StarMovieActivity : BaseActivity<MainViewModel>() {

    private val movieAdapter = MoviesRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityStarMovieBinding by lazy {
        ActivityStarMovieBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        CoroutineScope(Dispatchers.IO).launch {
            saveMovies()
            saveMovieDetails()
            saveMovieCast()
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

    private suspend fun saveMovieDetails() {
        viewModel.getMovieIds().forEach { viewModel.saveMoviesById(it) }
    }


    private suspend fun saveMovieCast() {
        viewModel.getMovieIds().forEach { viewModel.saveCastById(it) }
    }

    override fun liveDataObserver() {
        viewModel.getMovieAndDetails.observe(this, { list ->
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

