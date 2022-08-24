package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sigma.internship.mvvm.databinding.StarMovieRecycleItemBinding
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi
import com.sigma.internship.mvvm.ui.screens.main.DetailsActivity


class MoviesRecyclerAdapter() : RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder>() {

    private var poster: String = ""
    private var mylist = mutableListOf<MovieAndDetailsUi>()


    class RecyclerViewHolder(val binding: StarMovieRecycleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding =
            StarMovieRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding);
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerViewItem = mylist.get(position)

        with(holder) {
            with(mylist[position]) {

                //Log.d("test", mylist.toString())

                poster = "https://image.tmdb.org/t/p/w500" + recyclerViewItem.poster_path
                binding.posterIv.load(poster) //TODO placeholder https://www.youtube.com/watch?v=-1OU04S9EWg&ab_channel=EDMTDev

                binding.movieTitleTv.text = recyclerViewItem.original_title

                binding.genreTv.text = recyclerViewItem.genres.get(0).name

                binding.movieDurationTv.text = convertTime(mylist.get(position).runtime)

            }
        }

        holder.itemView.setOnClickListener {
            val id: String = holder.itemView.id.toString()

            val intent = Intent(holder.binding.root.context, DetailsActivity::class.java)
            intent.putExtra("id", id)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK //TODO add movie id to extras
            holder.binding.root.context.startActivity(intent)
        }

    }



    override fun getItemCount(): Int = mylist.size

    fun setSomeList(list: MutableList<MovieAndDetailsUi>) {
        mylist.addAll(list)
        notifyDataSetChanged()
    }

    fun convertTime(duration: Int):String{

        val hours = duration/60
        val min = duration % 60
        return String.format("%2dhr %02dm", hours, min)
    }

}
