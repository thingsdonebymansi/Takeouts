package com.guptamansi.takeouts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guptamansi.takeouts.databinding.BasketItemBinding
import java.util.ArrayList

class BasketAdapter(private var basketItems: MutableList<String>, private var basketItemPrice: MutableList<String>, private var basketItemImage: MutableList<Int>): RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {



    private var itemQuantities = IntArray(basketItems.size){ 1 }

    inner class BasketViewHolder(private val binding: BasketItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(basketItem: String, basketItemPrice: String, basketItemImage: Int, quantity: Int, position: Int) {
            binding.tVNameOfFoodInBasket.text = basketItem
            binding.tVPriceOfFoodInBasket.text = basketItemPrice
            binding.iVBasketItem.setImageResource(basketItemImage)
            binding.tVNoOfFoodItemsInBasket.text = quantity.toString()

            binding.ibtnPlus.setOnClickListener{
                increaseQuantity(position)
            }

            binding.ibtnMinus.setOnClickListener{
                decreaseQuantity(position)
            }

            binding.ibtnTrash.setOnClickListener{
                val itemPosition = adapterPosition
                if(itemPosition != RecyclerView.NO_POSITION){
                    deleteItem(itemPosition)
                }
            }

        }

        private fun increaseQuantity(position: Int) {
            if(itemQuantities[position] < 10){
                itemQuantities[position]++
                binding.tVNoOfFoodItemsInBasket.text = itemQuantities[position].toString()
            }

        }

        private fun decreaseQuantity(position: Int) {
            if(itemQuantities[position] > 1){
                itemQuantities[position]--
                binding.tVNoOfFoodItemsInBasket.text = itemQuantities[position].toString()
            }
        }

        private fun deleteItem(position: Int) {
            basketItems.removeAt(position)
            basketItemPrice.removeAt(position)
            basketItemImage.removeAt(position)
            val temp = itemQuantities.toMutableList()
            temp.removeAt(position)
            temp.toIntArray().copyInto(itemQuantities)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, basketItems.size)

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
        val quantity = itemQuantities[position]
        holder.bind(basketItem, basketItemPrice, basketItemImage, quantity, position)
    }
}