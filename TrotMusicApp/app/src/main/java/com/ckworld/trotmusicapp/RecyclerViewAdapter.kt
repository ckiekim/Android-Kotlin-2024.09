package com.ckworld.trotmusicapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(val songList: MutableList<SongModel>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bindItems(songList.get(position))
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindItems(song: SongModel) {
            val iv = itemView.findViewById<ImageView>(R.id.recyclerViewImage)
            // Glide를 사용하여 이미지 로드
            Glide.with(itemView)
                .load(song.url)
                .into(iv)
//            if (song.artist == "송가인")
//                iv.setImageResource(R.drawable.photo2)
//            if (song.artist == "영탁")
//                iv.setImageResource(R.drawable.photo3)

            itemView.findViewById<TextView>(R.id.recyclerViewTitle).setText(song.title)
            itemView.findViewById<TextView>(R.id.recyclerViewAlbum).setText(song.album)
        }
    }
}