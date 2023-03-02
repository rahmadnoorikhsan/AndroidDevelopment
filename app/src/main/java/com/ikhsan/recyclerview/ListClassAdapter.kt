package com.ikhsan.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikhsan.recyclerview.databinding.ItemRowClassBinding

class ListClassAdapter(private val listClasses: ArrayList<HomeWork>): RecyclerView.Adapter<ListClassAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rating, description, photo) = listClasses[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.binding.imgItemPicture.setImageResource(photo)
        holder.itemView.setOnClickListener{ onItemClickCallback.onItemClicked(listClasses[holder.adapterPosition])}
    }

    override fun getItemCount(): Int = listClasses.size

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowClassBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: HomeWork)
    }
}

