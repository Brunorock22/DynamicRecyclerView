package com.example.recyclerstudying.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerstudying.R
import kotlinx.android.synthetic.main.item_coment.view.*

class CommentsAdapter(private val comments: List<String>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(comment: String?) {
            comment?.let {
                itemView.comment.text = it
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        return CommentsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coment, parent, false)
        )

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind("${comments[position]} : $position")
    }

    override fun getItemCount(): Int = comments.size
}