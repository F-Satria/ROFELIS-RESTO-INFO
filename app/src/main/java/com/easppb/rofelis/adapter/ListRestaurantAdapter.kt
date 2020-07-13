package com.easppb.rofelis.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.easppb.rofelis.R
import com.easppb.rofelis.model.ListRestaurants
import com.easppb.rofelis.view.DetailActivity
import kotlinx.android.synthetic.main.item_row_restaurant.view.*

class ListRestaurantAdapter(private val list: List<ListRestaurants>) : RecyclerView.Adapter<ListRestaurantAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(restaurant: ListRestaurants) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(restaurant.descRestaurant.thumb)
                    .apply(RequestOptions().override(100, 100))
                    .into(img_item_photo)
                tv_restaurant.text = restaurant.descRestaurant.name
                tv_address.text = restaurant.descRestaurant.location.address
                tv_range.text = "Harga 2pax: " + restaurant.descRestaurant.average_cost_for_two + " " + restaurant.descRestaurant.currency
                tv_order_now.text = if(restaurant.descRestaurant.has_online_delivery=="0") {
                    "Order Online Tidak Tersedia"
                } else {
                    "Order Online Tersedia"
                }
                tv_rating.rating = restaurant.descRestaurant.UserRating.aggregate_rating.toFloat()
                tv_rating2.text = restaurant.descRestaurant.UserRating.aggregate_rating

                itemView.setOnClickListener { v ->
                    val intent = Intent(v.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID_RESTAURANT, restaurant.descRestaurant)
                    v.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_restaurant, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(list[holder.adapterPosition])
    }
}