package com.guptamansi.takeouts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guptamansi.takeouts.databinding.MenuItemBinding


class MenuAdapter(private val menuItems: MutableList<String>, private val menuItemPrice: MutableList<String>, private val menuImage: MutableList<Int>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(private val binding: MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.apply {
                tVNameOfMenuItem.text = menuItems[position]
                tVMenuItemPrice.text = menuItemPrice[position]
                iVMenuItem.setImageResource(menuImage[position])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

}