package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.app.NavUtils
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityCastBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CastActivity : BaseActivity<MainViewModel>() {

    override val viewModel by viewModel<MainViewModel>()
    private var id: Int = 0
    private val binding: ActivityCastBinding by lazy { ActivityCastBinding.inflate(layoutInflater) } //binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.greyarrow);
            supportActionBar?.title = "Cast & Crew"
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        val intent = intent
        id = intent.getIntExtra("id", 0)

        //Log.d("cast", id.toString())

    }

    override fun liveDataObserver() {

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                if (parentActivityIntent == null) {
                    onBackPressed()
                } else {
                    NavUtils.navigateUpFromSameTask(this)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}



