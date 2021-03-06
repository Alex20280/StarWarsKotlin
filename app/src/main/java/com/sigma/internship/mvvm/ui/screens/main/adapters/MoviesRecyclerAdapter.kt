package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sigma.internship.mvvm.data.network.models.response.popular.PopularResponseModel
import com.sigma.internship.mvvm.databinding.StarMovieRecycleItemBinding
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.models.moviewdetails.MovieRuntimeLocalModel
import com.sigma.internship.mvvm.ui.screens.main.MovieDetailsActivity
import com.sigma.internship.mvvm.ui.screens.main.Utils


class MoviesRecyclerAdapter(context: Context, movieList: ArrayList<PopularResponseModel>) : RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder>() {

    private lateinit var context: Context
    private lateinit var movieDetails: ArrayList<MovieLocalModel>
    private lateinit var movieListRuntime: ArrayList<MovieRuntimeLocalModel>
    private var poster: String = ""


    class RecyclerViewHolder(val binding: StarMovieRecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = StarMovieRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return RecyclerViewHolder(binding);
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerViewItem: MovieLocalModel = movieDetails.get(position)
        val recyclerViewRuntime: MovieRuntimeLocalModel = movieListRuntime.get(position)

        with(holder){
            with (movieDetails[position]){
                poster = "https://image.tmdb.org/t/p/w500" + recyclerViewItem.posterPath
                Glide.with(context).load(poster).apply(RequestOptions.centerCropTransform())
                    .into(binding.posterIv)

                binding.movieTitleTv.text = recyclerViewItem.title

                //binding.genreTv.text = recyclerViewItem.genreIds.toString()
                //genreList = recyclerViewItem.genre_ids
                binding.genreTv.text =
                    Utils.getGenre(recyclerViewItem.genreIds, Utils.CONSTANT_MAP).toString()
                        .replace("[", "").replace("]", "")

                binding.movieDurationTv.text = recyclerViewRuntime.runtime.toString()
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = movieDetails.size

}
