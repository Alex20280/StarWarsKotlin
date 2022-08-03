package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.databinding.ActivityStarMovieBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.adapters.MoviesRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class StarMovieActivity : BaseActivity<MainViewModel>() {

    private lateinit var adapter: MoviesRecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    lateinit var movieList: ArrayList<ResultResponseModel> //!

    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityStarMovieBinding by lazy { ActivityStarMovieBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        getDataFromApi()
        getDataFromDb()
        initRecyclerView()
    }

    private fun getDataFromDb() {
        viewModel.getPopularMoviesFromDb()
    }

    private fun getDataFromApi() {
        viewModel.savePopularMovies()
    }


    private fun initRecyclerView() {
        movieList = ArrayList()
        val recyclerView = binding.activityMainRecyclerView
        recyclerView.setHasFixedSize(true)
        adapter = MoviesRecyclerAdapter(movieList)
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        Log.d("recycler","Initialize RecyclerView")
    }

    override fun liveDataObserver() {
        viewModel.getMovieDetails.observe(this, {
            Log.d("title", it.first().title)
        })
/*        viewModel.getCast.observe(this, {
            Log.d("111", it.get(1).name)
        })
        viewModel.getPopularMovies.observe(this,{
            Log.d("111", it.first().results.get(1).title)
        })*/
    }
}