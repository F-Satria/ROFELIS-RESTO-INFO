package com.easppb.rofelis.network

import com.easppb.rofelis.model.ListRestaurants
import com.easppb.rofelis.model.Review
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ReviewDatasource {
    @Headers("user-key: 6e5056fee63c97ed1e7fad9074713568")

    @GET("reviews")

    fun discoverReview(
        @Query("res_id")
        res_id: Int = 18477915
    ): Call<Review>
}