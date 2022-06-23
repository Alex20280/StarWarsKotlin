package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.data.db.entities.MovieResponseModel
import com.sigma.internship.mvvm.databinding.ActivitySplashBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    private val database = MoviesDatabase

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.Main).launch {
            val popularMovies: Unit = viewModel.savePopularMovies()
            database.getInstance(applicationContext).getMovieDao().savePopularMovies(popularMovies)
            delay(3000)
            startActivity(Intent(this@SplashActivity, StarMovieActivity::class.java))
        }

    }

    override fun liveDataObserver() {
    }

}
