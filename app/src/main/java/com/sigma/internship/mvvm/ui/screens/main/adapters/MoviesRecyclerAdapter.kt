package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.databinding.StarMovieRecycleItemBinding
import com.sigma.internship.mvvm.ui.models.movie.MovieLocalModel
import com.sigma.internship.mvvm.ui.screens.main.MovieDetailsActivity
import com.sigma.internship.mvvm.ui.screens.main.Utils


class MoviesRecyclerAdapter(private val list: ArrayList<ResultResponseModel>) : RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder>() {

    private lateinit var context: Context
    private var poster: String = ""
    var mylist = emptyList<MovieLocalModel>()


    class RecyclerViewHolder(val binding: StarMovieRecycleItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = StarMovieRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return RecyclerViewHolder(binding);
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerViewItem = mylist.get(position)

        with(holder){
            with (mylist[position]){
                poster = "https://image.tmdb.org/t/p/w500" + recyclerViewItem.posterPath
                Glide.with(context).load(poster).apply(RequestOptions.centerCropTransform()) //TODO Use Coil instead
                    .into(binding.posterIv)

                binding.movieTitleTv.text = recyclerViewItem.title

                //binding.genreTv.text = recyclerViewItem.genreIds.toString()
                //genreList = recyclerViewItem.genre_ids
                binding.genreTv.text =
                    Utils.getGenre(recyclerViewItem.genreIds, Utils.CONSTANT_MAP).toString()
                        .replace("[", "").replace("]", "")

                binding.movieDurationTv.text = mylist.get(position).runtime.toString()
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetailsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK //TODO add movie id to extras
            context.startActivity(intent)
        }

    }



    override fun getItemCount(): Int = list.size

}
