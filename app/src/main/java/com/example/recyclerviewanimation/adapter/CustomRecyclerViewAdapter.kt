package com.example.recyclerviewanimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TwoLineListItem
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.recyclerviewanimation.R

class CustomRecyclerViewAdapter: Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
                LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindItems()
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems() {
            val twoLineListItem = itemView as TwoLineListItem
            val textView = twoLineListItem[0] as TextView
            val textViewSecond = twoLineListItem[1] as TextView
            textView.text = itemView.context.getString(R.string.sample_text_item)
            textViewSecond.text = itemView.context.getString(R.string.sample_text_item_2)
        }
    }

}