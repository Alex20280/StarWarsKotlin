package com.sigma.internship.mvvm.ui.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sigma.internship.mvvm.databinding.ActivityCastBinding

class CastActivity : AppCompatActivity() {

    //override val viewModel: MainViewModel by viewModel()
    private val binding: ActivityCastBinding by lazy { ActivityCastBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}



