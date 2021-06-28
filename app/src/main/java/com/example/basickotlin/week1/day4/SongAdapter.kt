package com.example.basickotlin.week1.day4

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basickotlin.R
import kotlinx.android.synthetic.main.song_item.view.*

class SongAdapter(
    var songList : MutableList<Song>
) : RecyclerView.Adapter<SongAdapter.songHolder>() {
    class songHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): songHolder {
        return songHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.song_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: songHolder, position: Int) {
        songList.forEach { song ->  Log.d("SONGONBIND", song.toString())}
        val current = songList[position]
        Log.d("CURRENT", current.toString())
        holder.itemView.apply {
            imgRecView.setImageBitmap(current.image)
            tvTitle.text = current.title
            tvDes.text = current.album
            txtArtist.text = current.artist

            Log.d("BINDED", "Current: TITLE:" + current.title
            +"ALBUM:" + current.album
            +"ARTIST:" + current.artist
            )
        }
    }

    override fun getItemCount(): Int {
        return songList.size
    }

}

