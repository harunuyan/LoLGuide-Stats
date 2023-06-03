package com.volie.lolguidestats.ui.fragment.item_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.volie.lolguidestats.data.model.item.Item
import com.volie.lolguidestats.databinding.ItemIntoAndFromBinding
import com.volie.lolguidestats.helper.Constant.ITEM_IMAGE
import com.volie.lolguidestats.ui.adapter.BaseAdapter

class ItemIntoAdapter(
    private val onItemClick: (Item) -> Unit
) : BaseAdapter<Item>(ItemIntoDiffCallback()) {

    inner class ItemIntoViewHolder(private val binding: ItemIntoAndFromBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val itemInto = currentList[position]
            Glide.with(binding.root)
                .load("${ITEM_IMAGE}${itemInto.into.get(position)}.png")
                .into(binding.ivItem)

            binding.root.setOnClickListener {
                onItemClick(itemInto)
            }
        }
    }

    override fun createViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = ItemIntoAndFromBinding.inflate(inflater, parent, false)
        return ItemIntoViewHolder(binding)
    }

    override fun bindViewHolder(holder: RecyclerView.ViewHolder, item: Item, position: Int) {
        if (holder is ItemIntoViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}

class ItemIntoDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}
