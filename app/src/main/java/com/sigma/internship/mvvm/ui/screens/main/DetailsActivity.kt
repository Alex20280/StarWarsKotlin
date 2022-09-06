package com.sigma.internship.mvvm.ui.screens.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NavUtils
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.databinding.ActivityMovieDetailsBinding
import com.sigma.internship.mvvm.ui.UtilsUi
import com.sigma.internship.mvvm.ui.base.BaseActivity
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi
import com.sigma.internship.mvvm.ui.screens.main.adapters.CastAndCrewRecyclerAdapter
import com.sigma.internship.mvvm.ui.screens.main.viewmodel.MainViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity<MainViewModel>() {

    private var id: Int = 0

    private val castAdapter = CastAndCrewRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

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

        lifecycleScope.launch {
            showData()
            viewModel.getCastFromDb(id)
        }
        initRecyclerView()

        binding.viewAllTv.setOnClickListener {
            val someIntent = Intent(this@DetailsActivity, CastActivity::class.java)
            someIntent.putExtra("id", id)
            startActivity(someIntent)
        }
    }
    override fun liveDataObserver() {
        viewModel.getCastById.observe(this, { list ->
            list.let {
                castAdapter.setSomeList(it)
            }
        })
    }

    private suspend fun showData() {
        val res = lifecycleScope.async {
            viewModel.getMovieByIdFromDb(id)
        }
        res.await().let {
            with(binding) {
                mainPosterIv.load(UtilsUi.BASE_URL + it.get(0).poster_path)
                moviewNameTv.text = it.get(0).title
                moviewDurationTv.text = convertTime(it.get(0).runtime)
                moviewGenreTv.text = it.get(0).genres.get(0).name
                sinopsinTextTv.text = it.get(0).overview
            }
        }

    }

    private fun initRecyclerView() {
        val recyclerView = binding.moviewDerailsReciclerView
        val snap = LinearSnapHelper()
        recyclerView.adapter = castAdapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setOnFlingListener(null);
        snap.attachToRecyclerView(recyclerView)
    }

/*    override fun liveDataObserver() {

        viewModel.getMovieAndDetailsById.observe(this, { list ->
            list.let {
                with(binding) {
                    mainPosterIv.load(UtilsUi.BASE_URL + it.get(0).poster_path)
                    moviewNameTv.text = it.get(0).title
                    moviewDurationTv.text = convertTime(runtime)
                    moviewGenreTv.text = it.get(0).genres.get(0).name
                    sinopsinTextTv.text = it.get(0).overview
                }
            }
        })
        viewModel.getCastById.observe(this, { list ->
            list.let {
                castAdapter.setSomeList(it)
            }
        })
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
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
            R.id.action_settings -> {
                val intent = Intent(this@DetailsActivity, CastActivity::class.java)
                intent.putExtra("id", id.toString())
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun convertTime(duration: Int): String {
        val hours = duration / 60
        val min = duration % 60
        return String.format("%2dhr %02dm", hours, min)
    }

}




/*
class DetailsActivity : BaseActivity<MainViewModel>() {

    private var id: Int = 0
    private var runtime: Int = 0

    private val castAdapter = CastAndCrewRecyclerAdapter()
    private var layoutManager: RecyclerView.LayoutManager? = null

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
        runtime = intent.getIntExtra("runtime", 0)

        viewModel.getMovieByIdFromDb(id)
        viewModel.getCastFromDb(id)

        initRecyclerView()

        binding.viewAllTv.setOnClickListener {
            val someIntent = Intent(this@DetailsActivity, CastActivity::class.java)
            someIntent.putExtra("id", id)
            startActivity(someIntent)
        }
    }

    private fun initRecyclerView() {
        val recyclerView = binding.moviewDerailsReciclerView
        if (!castAdapter.hasObservers()) {
            castAdapter.setHasStableIds(true)
        }
        val snap = LinearSnapHelper()
        recyclerView.adapter = castAdapter
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setOnFlingListener(null);
        snap.attachToRecyclerView(recyclerView)
    }

    override fun liveDataObserver() {

        viewModel.getMovieAndDetailsById.observe(this, { list ->
            list.let {
                with(binding) {
                    mainPosterIv.load(UtilsUi.BASE_URL + it.get(0).poster_path)
                    moviewNameTv.text = it.get(0).title
                    moviewDurationTv.text = convertTime(runtime)
                    moviewGenreTv.text = it.get(0).genres.get(0).name
                    sinopsinTextTv.text = it.get(0).overview
                }
            }
        })
        viewModel.getCastById.observe(this, { list ->
            list.let {
                castAdapter.setSomeList(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.forward_item, menu)
        return true
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
            R.id.action_settings -> {
                val intent = Intent(this@DetailsActivity, CastActivity::class.java)
                intent.putExtra("id", id.toString())
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun convertTime(duration: Int): String {
        val hours = duration / 60
        val min = duration % 60
        return String.format("%2dhr %02dm", hours, min)
    }
}*/
