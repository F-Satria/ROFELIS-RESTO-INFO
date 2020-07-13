package com.easppb.rofelis.network

import com.easppb.rofelis.model.Restaurant
import com.easppb.rofelis.model.Review
import com.easppb.rofelis.model.ListRestaurants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RestoDatasource {
    @Headers("user-key: 6e5056fee63c97ed1e7fad9074713568")

    @GET("search")
    fun discoverRestaurantFromSearch(
        @Query("entity_id")
        q: Int = 11052, //BANDUNG ENTITY ID
        @Query("entity_type")
        entity_type: String = "city"
    ): Call<Restaurant>
}