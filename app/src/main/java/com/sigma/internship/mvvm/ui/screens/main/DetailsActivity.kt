package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import coil.load
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityMovieDetailsBinding
import com.sigma.internship.mvvm.ui.UtilsUi
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

        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.backarrow);
            supportActionBar?.title = ""
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        val intent = intent
        id = intent.getIntExtra("id", 0)

        Log.d("text1", id.toString())
        viewModel.getMovieByIdFromDb(id)
    }

    override fun liveDataObserver() {

        Log.d("text", id.toString())
        viewModel.getMovieAndDetailsById.observe(this, { list ->
                list.let {
                    with(binding) {
                        mainPosterIv.load(UtilsUi.POSTER_BASE+it.get(0).poster_path)
                        moviewNameTv.text = it.get(0).title
                        moviewDurationTv.text = convertTime(it.get(0).runtime)
                        moviewGenreTv.text = it.get(0).genres.get(0).name
                        sinopsinTextTv.text = it.get(0).overview
                    }
                }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.menu.forward_item -> startActivity(Intent(this@DetailsActivity, CastActivity::class.java))
            R.id.home -> startActivity(Intent(this@DetailsActivity, StarMovieActivity::class.java))
        }
        return true
    }

    fun convertTime(duration: Int):String{
        val hours = duration/60
        val min = duration % 60
        return String.format("%2dhr %02dm", hours, min)
    }
}