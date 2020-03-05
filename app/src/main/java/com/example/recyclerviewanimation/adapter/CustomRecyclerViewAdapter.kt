package com.example.recyclerviewanimation.adapter

import android.os.Build
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.recyclerviewanimation.R
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class CustomRecyclerViewAdapter(
        recycler: RecyclerView
) : Adapter<CustomRecyclerViewAdapter.CustomViewHolder>() {

    private val recyclerView = recycler


    private var mExpandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 12
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindItems()
        val isExpanded = position == mExpandedPosition
        holder.itemView.layout.visibility = (if (isExpanded) View.VISIBLE else View.GONE)
        holder.itemView.isActivated = isExpanded
        holder.itemView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(recyclerView)
            }
            notifyDataSetChanged()
        }
    }


    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems() {
            val layout = itemView.findViewById<LinearLayout>(R.id.layout)
            layout.setBackgroundColor(itemView.context.resources.getColor(R.color.colorPrimaryDark))
        }
    }

}