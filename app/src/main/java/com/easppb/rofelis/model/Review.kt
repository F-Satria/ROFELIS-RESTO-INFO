package com.easppb.rofelis.model

import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("user_reviews")
    val rev: List<ListReview>
)

data class ListReview(
    @SerializedName("review")
    val descReview: DescReview
)

data class DescReview(
    @SerializedName("rating")
    val rating: Int,
    @SerializedName("review_text")
    val text: String,
    @SerializedName("review_time_friendly")
    val time: String,
    @SerializedName("user")
    val user: User
)

data class User(
    @SerializedName("name")
    val name: String
)
