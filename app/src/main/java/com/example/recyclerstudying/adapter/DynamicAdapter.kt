package com.example.recyclerstudying.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerstudying.R
import com.example.recyclerstudying.ReviewRow
import com.example.recyclerstudying.adapter.viewholder.GeralViewHolder
import kotlinx.android.synthetic.main.item_coment.view.*

class ReviewAdapter(private val viewHolderDatas: List<ReviewRow>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val layoutMap = mutableMapOf<Int, Int>()

    init {
        setepUp()
    }

    private fun setepUp() {
        viewHolderDatas.forEach {
            check(!layoutMap.containsKey(it.viewType) || layoutMap[it.viewType] == it.viewType) {
                "Cannot pass same viewType with different layoutRes values."
            }
            layoutMap[it.viewType] = it.viewType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.image_review -> {
                GeralViewHolder.MovieImageViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(viewType, parent, false)
                )
            }
            R.layout.header_review -> {
                GeralViewHolder.HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(viewType, parent, false)
                )
            }
            else -> GeralViewHolder.ComentsViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.comments_review, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is GeralViewHolder.MovieImageViewHolder -> {
                holder.bind()
            }
            is GeralViewHolder.ComentsViewHolder -> {
                var viewHolder = viewHolderDatas[position] as ReviewRow.ViewHolderComments
                holder.bind(viewHolder.genericData)
            }
        }
    }

    override fun getItemCount(): Int = viewHolderDatas.size

    override fun getItemViewType(position: Int) = viewHolderDatas[position].viewType

    inner class GeneralViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}