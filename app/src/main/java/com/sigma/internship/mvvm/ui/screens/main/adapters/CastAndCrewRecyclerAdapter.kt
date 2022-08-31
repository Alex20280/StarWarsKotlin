package com.sigma.internship.mvvm.ui.screens.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sigma.internship.mvvm.databinding.CastRecycleItemBinding
import com.sigma.internship.mvvm.ui.UtilsUi
import com.sigma.internship.mvvm.ui.models.cast.CastUi

//https://medium.com/swlh/how-to-use-view-binding-in-recyclerview-adapter-f818b96c678a#:~:text=View%20binding%20is%20a%20feature,file%20present%20in%20that%20module.

class CastAndCrewRecyclerAdapter(): RecyclerView.Adapter<CastAndCrewRecyclerAdapter.CastAndCrewHolder>(){

    private var mylist = mutableListOf<CastUi>()

    class CastAndCrewHolder(val binding: CastRecycleItemBinding): RecyclerView.ViewHolder(binding.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastAndCrewHolder {
        val binding = CastRecycleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CastAndCrewHolder(binding);
    }

    override fun onBindViewHolder(holder: CastAndCrewHolder, position: Int) {
        val recyclerViewItem = mylist.get(position)

        with(holder) {
            with(mylist[position]) {

                binding.actorImageView.load(UtilsUi.BASE_URL + recyclerViewItem.profile_path)
                binding.actornameTv.text = recyclerViewItem.name
                binding.characterTv.text = recyclerViewItem.character //TODO placeholder https://www.youtube.com/watch?v=-1OU04S9EWg&ab_channel=EDMTDev

            }
        }
    }



    override fun getItemCount(): Int = mylist.size

    fun setSomeList(list: MutableList<CastUi>) {
        mylist.addAll(list)
        notifyDataSetChanged()
    }


}