package com.guptamansi.takeouts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guptamansi.takeouts.adapter.PopularAdapter.PopularViewHolder
import com.guptamansi.takeouts.databinding.FragmentHomeBinding
import com.guptamansi.takeouts.databinding.PopulerItemBinding

class PopularAdapter(private val items: List<String>, private val image: List<Int>, private val price: List<String>): RecyclerView.Adapter<PopularViewHolder>() {
    class PopularViewHolder(private val binding: PopulerItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.iVPopularItem
        fun bind(item: String, images: Int, price: String){
            binding.tVNameOfPopularItem.text = item
            binding.tVItemPrice.text = price
            imagesView.setImageResource(images)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopulerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val image = image[position]
        val price = price[position]
        holder.bind(item,image,price)
    }
}