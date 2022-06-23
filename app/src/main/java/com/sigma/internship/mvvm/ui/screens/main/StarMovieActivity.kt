package com.sigma.internship.mvvm.ui.screens.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import com.sigma.internship.mvvm.databinding.ActivityStarMovieBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.adapters.MoviesRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class StarMovieActivity : BaseActivity<MainViewModel>() {

    private lateinit var context: Context
    private lateinit var adapter: MoviesRecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    var movieList: ArrayList<PopularResponseModel>? = null

    override val viewModel: MainViewModel by viewModel()

    private val binding: ActivityStarMovieBinding by lazy { ActivityStarMovieBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = viewModel.savePopularMovies()
        Log.d("data","get data $list")

        initRecyclerView()
    }



    private fun initRecyclerView() {
        movieList = ArrayList()
        val recyclerView = binding.activityMainRecyclerView
        recyclerView.setHasFixedSize(true)
        adapter = MoviesRecyclerAdapter(context, movieList!!)
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        Log.d("recycler","Initialize RecyclerView")
    }

    override fun liveDataObserver() {
        viewModel.getPopularMovies.observe(this, {
            Log.d("111", it.first().title)
        })
    }
}