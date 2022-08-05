package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sigma.internship.mvvm.R
import com.sigma.internship.mvvm.data.network.models.response.popular.ResultResponseModel
import com.sigma.internship.mvvm.databinding.CastRecycleItemBinding
import com.sigma.internship.mvvm.ui.models.cast.CastLocal

//https://medium.com/swlh/how-to-use-view-binding-in-recyclerview-adapter-f818b96c678a#:~:text=View%20binding%20is%20a%20feature,file%20present%20in%20that%20module.

class CastAndCrewRecyclerAdapter(private val list: ArrayList<ResultResponseModel>): RecyclerView.Adapter<CastAndCrewRecyclerAdapter.CastAndCrewHolder>(){

    private lateinit var context: Context
    private lateinit var movieCast: ArrayList<CastLocal>
    private var poster: String = ""


    class CastAndCrewHolder(val binding: CastRecycleItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAndCrewHolder {
        val binding = CastRecycleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CastAndCrewHolder(binding)
    }

    override fun onBindViewHolder(holder: CastAndCrewHolder, position: Int) {
        val recyclerViewCast: CastLocal = movieCast.get(position)

        with(holder){
            with(movieCast[position]){
                poster = "https://image.tmdb.org/t/p/w500" + recyclerViewCast.profile_path

                binding.actorImageView.load(poster){placeholder(R.drawable.ic_baseline_search_24)} //TODO placeholder
/*                Glide.with(context).load(poster).apply(RequestOptions.centerCropTransform())
                    .into(binding.actorImageView)*/

                binding.actornameTv.text = recyclerViewCast.name

                binding.characterTv.text = recyclerViewCast.character
            }
        }
    }

    override fun getItemCount(): Int = list.size
}