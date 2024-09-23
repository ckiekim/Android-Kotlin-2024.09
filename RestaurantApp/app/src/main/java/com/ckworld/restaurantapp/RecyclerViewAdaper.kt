package com.ckworld.restaurantapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdaper(val context:  Context, val list: MutableList<ContentsModel>):
    RecyclerView.Adapter<RecyclerViewAdaper.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdaper.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(v)
    }

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder: RecyclerViewAdaper.ViewHolder, position: Int) {
        if (itemClick != null) {
            holder?.itemView?.setOnClickListener {
                itemClick!!.onClick(it, position)
            }
        }
        holder.bindItems(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(item: ContentsModel) {
            val imageUrl = itemView.findViewById<ImageView>(R.id.imageUrl)
            val title = itemView.findViewById<TextView>(R.id.title)

            title.text = item.title
            Glide.with(context)
                .load(item.imageUrl)
                .into(imageUrl)
        }
    }
}