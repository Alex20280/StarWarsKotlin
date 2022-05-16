package com.sigma.internship.mvvm.ui.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sigma.internship.mvvm.databinding.ActivityCastAndCrewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CastAndCrewActivity : AppCompatActivity() {

    //override val viewModel: MainViewModel by viewModel()
    private val binding: ActivityCastAndCrewBinding by lazy { ActivityCastAndCrewBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}



