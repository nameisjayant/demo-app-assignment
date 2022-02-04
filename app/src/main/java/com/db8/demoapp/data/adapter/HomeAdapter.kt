package com.db8.demoapp.data.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.db8.demoapp.data.model.Home
import com.db8.demoapp.databinding.EachRowBinding

class HomeAdapter(private val activity: Activity) :
    ListAdapter<Home.AvailableProducts, HomeAdapter.HomeViewHolder>(Diff) {

    inner class HomeViewHolder(private val binding: EachRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(home: Home.AvailableProducts) {
            binding.title.text = home.title
            binding.amount.text = "$ ${home.price.amount}"
            Glide.with(activity)
                .load(home.thumbnailUrl)
                .into(binding.image)
        }
    }

    object Diff : DiffUtil.ItemCallback<Home.AvailableProducts>() {
        override fun areItemsTheSame(
            oldItem: Home.AvailableProducts,
            newItem: Home.AvailableProducts
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Home.AvailableProducts,
            newItem: Home.AvailableProducts
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = EachRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val home = getItem(position)
        if (home != null)
            holder.bind(home)
    }
}