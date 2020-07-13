package com.easppb.rofelis.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.easppb.rofelis.R
import com.easppb.rofelis.adapter.ListRestaurantAdapter
import com.easppb.rofelis.adapter.ListReviewAdapter
import com.easppb.rofelis.model.Restaurant
import com.easppb.rofelis.model.Review
import com.easppb.rofelis.network.NetworkProvider
import com.easppb.rofelis.network.RestoDatasource
import com.easppb.rofelis.network.ReviewDatasource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.pb_main)
        val datasource = NetworkProvider.providesHttpAdapter().create(RestoDatasource::class.java)

        datasource.discoverRestaurantFromSearch().enqueue(object : Callback<Restaurant> {
            override fun onResponse(call: Call<Restaurant>, response: Response<Restaurant>) {
                progressBar.visibility = View.GONE
                val results = response.body()?.cities
                val itemAdapter = findViewById<RecyclerView>(R.id.rv_restaurant)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = ListRestaurantAdapter(results ?: emptyList())
            }

            override fun onFailure(call: Call<Restaurant>, t: Throwable) {
                Log.e(MainActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })
    }
}