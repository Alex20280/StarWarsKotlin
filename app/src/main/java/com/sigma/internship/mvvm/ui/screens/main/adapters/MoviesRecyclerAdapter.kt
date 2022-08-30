package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.sigma.internship.mvvm.databinding.StarMovieRecycleItemBinding
import com.sigma.internship.mvvm.ui.UtilsUi
import com.sigma.internship.mvvm.ui.models.movie.MovieAndDetailsUi


class MoviesRecyclerAdapter() : RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder>(){

    private lateinit var mListener: onItemClickListener
    private var mylist = mutableListOf<MovieAndDetailsUi>()

    interface onItemClickListener{
        fun onItemClick (position: Int)
    }

    fun setOnclickListener (listener: onItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding =
            StarMovieRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerViewHolder(binding, mListener);
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val recyclerViewItem = mylist.get(position)

        with(holder) {
            with(mylist[position]) {

                binding.posterIv.load(UtilsUi.POSTER_BASE + recyclerViewItem.poster_path) //TODO placeholder https://www.youtube.com/watch?v=-1OU04S9EWg&ab_channel=EDMTDev

                binding.movieTitleTv.text = recyclerViewItem.title

                binding.genreTv.text = recyclerViewItem.genres.get(0).name

                binding.movieDurationTv.text = convertTime(mylist.get(position).runtime)

            }
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

    class RecyclerViewHolder(val binding: StarMovieRecycleItemBinding,  listener: onItemClickListener): RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                listener.onItemClick(bindingAdapterPosition)
            }
        }


    }

}
