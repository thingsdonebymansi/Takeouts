package com.guptamansi.takeouts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guptamansi.takeouts.databinding.BasketItemBinding

class BasketAdapter(private val basketItems: List<String>, private val basketItemPrice: List<String>, private val basketItemImage: List<Int>): RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {



    class BasketViewHolder(private val binding: BasketItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(basketItem: String, basketItemPrice: String, basketItemImage: Int) {
            binding.tVNameOfFoodInBasket.text = basketItem
            binding.tVPriceOfFoodInBasket.text = basketItemPrice
            binding.iVBasketItem.setImageResource(basketItemImage)
            binding.tVNoOfFoodItemsInBasket.text = "1"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketViewHolder {
        return BasketViewHolder(BasketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = basketItems.size

    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        val basketItem = basketItems[position]
        val basketItemPrice = basketItemPrice[position]
        val basketItemImage = basketItemImage[position]
        holder.bind(basketItem, basketItemPrice, basketItemImage)
    }
}