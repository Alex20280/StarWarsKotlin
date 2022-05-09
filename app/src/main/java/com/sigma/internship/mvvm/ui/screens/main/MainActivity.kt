package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import android.util.Log
import com.sigma.internship.mvvm.databinding.ActivityMainBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getPopularMovies()
    }

    override fun liveDataObserver() {
        viewModel.getPopularMovies.observe(this, {
            Log.d("111", it.first().title)
        })
    }



}