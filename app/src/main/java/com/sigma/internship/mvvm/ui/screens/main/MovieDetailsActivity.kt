package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.data.db.MoviesDatabase
import com.sigma.internship.mvvm.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var photo: String
    private lateinit var genreList: ArrayList<Int>
    private lateinit var overView: String


    //override val viewModel: MainViewModel by viewModel() //TODO
    private val binding: ActivityMovieDetailsBinding by lazy { ActivityMovieDetailsBinding.inflate(layoutInflater) } //binding

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val intent = intent
        name = intent.getStringExtra("name").toString()
        photo = intent.getStringExtra("photo").toString()
        genreList = intent.getIntegerArrayListExtra("genre") as ArrayList<Int>
        overView = intent.getStringExtra("overview").toString()


        Glide.with(this).load(photo).apply(RequestOptions.centerCropTransform()).into(binding.mainPosterIv)

        binding.moviewNameTv.text = name

        binding.moviewGenreTv.setText(
            Utils.getGenreList(genreList, Utils.CONSTANT_MAP).toString().replace("[", "")
                .replace("]", "")
        )

        binding.sinopsinTextTv.setText(overView)

        binding.viewAllTv.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CastActivity::class.java)
            startActivity(intent)
        })
    }
}