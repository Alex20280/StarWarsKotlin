package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityStarMovieBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi
import com.sigma.internship.mvvm.ui.screens.main.adapters.MoviesRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class StarMovieActivity : BaseActivity<MainViewModel>() {

    private val movieAdapter = MoviesRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var mylist = mutableListOf<MovieAndDetailsUi>()

    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityStarMovieBinding by lazy {
        ActivityStarMovieBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.title = "Star Movie"

    }

    override fun onStart() {
        super.onStart()

        CoroutineScope(Dispatchers.IO).launch {
            saveMovies()
            saveMovieDetails()
            //saveMovieCast()
        }
        initRecyclerView()

    }

    private fun initRecyclerView() {
        val recyclerView = binding.activityMainRecyclerView
        movieAdapter.setHasStableIds(true)
        val snap = LinearSnapHelper()
        recyclerView.adapter = movieAdapter
        movieAdapter.setOnclickListener(object : MoviesRecyclerAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                mylist = viewModel.getPopularMovies.value!!
                val recyclerViewItem = mylist?.get(position)
                val intent = Intent(this@StarMovieActivity, DetailsActivity::class.java)
                intent.putExtra("id", recyclerViewItem?.id)
                startActivity(intent)
            }

        })
        layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        snap.attachToRecyclerView(recyclerView)
    }

    private suspend fun saveMovies() {
        viewModel.saveMovies()
    }

    private suspend fun saveMovieDetails() {
        viewModel.getMovieIds().forEach { viewModel.saveDetailsById(it) }
    }


    private suspend fun saveMovieCast() {
        viewModel.getMovieIds().forEach { viewModel.saveCastById(it) }
    }

    override fun liveDataObserver() {
        viewModel.getPopularMovies()
        viewModel.getPopularMovies.observe(this, { list ->
            list.let {
                movieAdapter.setSomeList(it)
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> Toast.makeText(this, "Search", Toast.LENGTH_LONG)
                .show() //TODO make search function
        }
        return true
    }

}

