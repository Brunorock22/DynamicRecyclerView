package com.example.recyclerstudying.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerstudying.adapter.CommentsAdapter
import kotlinx.android.synthetic.main.comments_review.view.*

sealed class GeralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    class ComentsViewHolder(itemView: View) : GeralViewHolder(itemView) {
        fun bind(userComments: List<String>) {
            userComments?.let {
                itemView.recycler_comments.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = CommentsAdapter(userComments)
                }
            }
        }
    }

    class MovieImageViewHolder(itemView: View) : GeralViewHolder(itemView) {
        fun bind() {

        }
    }

    class HeaderViewHolder(itemView: View): GeralViewHolder(itemView){

    }
}
