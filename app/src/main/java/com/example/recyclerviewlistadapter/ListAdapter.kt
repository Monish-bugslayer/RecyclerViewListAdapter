package com.example.recyclerviewlistadapter


import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerviewlistadapter.databinding.ViewItemBinding

class FeedAdapter(private var feedList:MutableList<Feeds>):ListAdapter<Feeds, FeedAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    private lateinit var listner: OnItemClickListner

    inner class FeedViewHolder(val binding:ViewItemBinding,listner: OnItemClickListner):RecyclerView.ViewHolder(binding.root){
        init {
            itemView. setOnClickListener {
                listner.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {

        return FeedViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),listner)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentFeed=feedList[position]
        holder.binding.imageView.setImageResource(currentFeed.img)
        holder.binding.headline.text=currentFeed.headlines

    }

    fun setOnClickListner(listner:OnItemClickListner){
        this.listner=listner
    }

}

class FeedDiffCallBack:DiffUtil.ItemCallback<Feeds>(){
    override fun areItemsTheSame(oldItem: Feeds, newItem: Feeds): Boolean {
        return oldItem.headlines==newItem.headlines
    }

    override fun areContentsTheSame(oldItem: Feeds, newItem: Feeds): Boolean {
        return areItemsTheSame(oldItem,newItem)
    }

}