package com.easppb.rofelis.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easppb.rofelis.R
import com.easppb.rofelis.model.ListReview
import kotlinx.android.synthetic.main.item_row_review.view.*

class ListReviewAdapter(private val list: List<ListReview>) : RecyclerView.Adapter<ListReviewAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(review: ListReview) {
            with(itemView) {
                rb_rating.rating = review.descReview.rating.toFloat()
                tv_rating_text.text = review.descReview.text
                tv_review_date.text = review.descReview.time
                tv_reviewer_name.text = review.descReview.user.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_review, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }
}