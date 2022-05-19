package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sigma.internship.mvvm.data.network.models.response.movie.MovieResponseModel
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import com.sigma.internship.mvvm.databinding.StarMovieRecycleItemBinding
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieDurationLocalModel
import com.sigma.internship.mvvm.ui.screens.main.MovieDetailsActivity
import com.sigma.internship.mvvm.ui.screens.main.Utils


class MoviesRecyclerAdapter constructor(context: Context, list: ArrayList<PopularResponseModel>) :
    RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder>() {

    private lateinit var context: Context
    private lateinit var movieDetails: ArrayList<MovieLocalModel>
    private lateinit var movieListDuration: ArrayList<MovieDurationLocalModel>
    private var poster: String =""

    private val binding: StarMovieRecycleItemBinding by lazy {
        StarMovieRecycleItemBinding.inflate(
            LayoutInflater.from(context)
        )
    } //binding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = StarMovieRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerViewItem: MovieLocalModel = movieDetails.get(position)
        val recyclerViewDuration: MovieDurationLocalModel = movieListDuration.get(position)

        poster = "https://image.tmdb.org/t/p/w500" + recyclerViewItem.posterPath
        Glide.with(context).load(poster).apply(RequestOptions.centerCropTransform())
            .into(binding.posterIv)

        binding.movieTitleTv.text = recyclerViewItem.title

        //binding.genreTv.text = recyclerViewItem.genreIds.toString()
        //genreList = recyclerViewItem.genre_ids
        binding.genreTv.text = Utils.getGenre(recyclerViewItem.genreIds, Utils.CONSTANT_MAP).toString().replace("[", "").replace("]", "")

        binding.movieDurationTv.text = recyclerViewDuration.runtime.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = movieDetails.size

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
