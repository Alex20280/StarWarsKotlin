package com.sigma.internship.mvvm.ui.screens.main

import android.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sigma.internship.mvvm.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.root.postDelayed({
            val intent = Intent(this, StarMovieActivity::class.java)
            startActivity(intent)
            finish()
        }, (5 * 1000).toLong())

        /*
        Handler().postDelayed({
            val intent = Intent(this, StarMovieActivity::class.java)
            startActivity(intent)
            finish()
        }, (5 * 1000).toLong())

         */
    }



}
