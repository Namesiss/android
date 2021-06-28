package com.example.basickotlin.week2.day1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basickotlin.R
import com.example.basickotlin.week2.day1.model.Owner
import com.example.basickotlin.week2.day1.model.RecyclerData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler.view.*
import java.util.ArrayList

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyView>() {
    var items = ArrayList<RecyclerData>()
            fun setUpdatedData(items : ArrayList<RecyclerData>) {
                this.items = items
                notifyDataSetChanged()
            }
    public class MyView(view: View) : RecyclerView.ViewHolder(view){

        fun bind(data : RecyclerData){
            itemView.tvTitle.text = data.name
            itemView.tvDes.text = data.description
            val url = data.owner.avatar_url

            Picasso.get()
                .load(url)
                .into(itemView.imgRecView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

}