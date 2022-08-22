package com.sigma.internship.mvvm.ui.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sigma.internship.mvvm.databinding.ActivityCastBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel

class CastActivity : BaseActivity<MainViewModel>() {

    //override val viewModel: MainViewModel by viewModel()
    private val binding: ActivityCastBinding by lazy { ActivityCastBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override val viewModel: MainViewModel
        get() = TODO("Not yet implemented")

    override fun liveDataObserver() {
        TODO("Not yet implemented")
    }
}



