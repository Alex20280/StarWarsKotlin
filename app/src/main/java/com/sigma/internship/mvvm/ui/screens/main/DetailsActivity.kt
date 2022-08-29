package com.sigma.internship.mvvm.ui.screens.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityMovieDetailsBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity<MainViewModel>() {

    private var id: Int = 0

    override val viewModel by viewModel<MainViewModel>()

    private val binding: ActivityMovieDetailsBinding by lazy {
        ActivityMovieDetailsBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        val intent = intent
        id = intent.getIntExtra("id", 0)

        binding.moviewNameTv.text = id.toString()
    }

    override fun liveDataObserver() {
/*        viewModel.getMovieByIdFromDb(id)
        viewModel.getMovieAndDetailsById.observe(this, { list ->
                list.let {
                    with(binding) {
                        mainPosterIv.load(it.get(0).poster_path)
                        moviewNameTv.text = it.get(0).title
                        moviewGenreTv.text = it.get(0).genres.get(0).name
                        sinopsinTextTv.text = it.get(0).overview
                    }
                }
        })*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.menu.forward_item -> Toast.makeText(this, "Forward button pressed", Toast.LENGTH_LONG)
                .show()
        }
        return true
    }
}