package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.lifecycle.viewModelScope
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityMovieDetailsBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity<MainViewModel>() {

    private var id: Int = 0

    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityMovieDetailsBinding by lazy { ActivityMovieDetailsBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        id = intent.getIntExtra("id", 0)
        Toast.makeText(this,id, Toast.LENGTH_LONG).show()

        viewModel.viewModelScope.launch {
            viewModel.getMovieByIdFromDb(id)
        }


        //binding.mainPosterIv.load(photo)
        //binding.moviewNameTv.text = name
        //binding.moviewGenreTv.setText
        //binding.sinopsinTextTv.setText(overView)

    }

    override fun liveDataObserver() {
        viewModel.getMovieAndDetailsById.observe(this, { list ->

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
    }
}