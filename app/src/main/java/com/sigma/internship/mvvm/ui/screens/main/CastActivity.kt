package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.app.NavUtils
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityCastBinding
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.screens.main.adapters.CastAndCrewRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CastActivity : BaseActivity<MainViewModel>() {

    private var id: Int = 0

    private val castAdapter = CastAndCrewRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

    override val viewModel by viewModel<MainViewModel>()
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

        val intent = getIntent();
        if(intent != null) {
            id = getIntent().getIntExtra("id", 0)
        }

        lifecycleScope.launch {
            viewModel.getCastFromDb(id)
        }
        initRecyclerView()

    }

    override fun liveDataObserver() {

        viewModel.getCastById.observe(this, { list ->
            list.let {
                castAdapter.setSomeList(it)
            }

        })
    }

    private fun initRecyclerView() {
        val recyclerView = binding.activityCastRecyclerView
        val snap = LinearSnapHelper()
        recyclerView.adapter = castAdapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setOnFlingListener(null);
        snap.attachToRecyclerView(recyclerView)
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



