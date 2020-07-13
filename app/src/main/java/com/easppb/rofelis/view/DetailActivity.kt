package com.easppb.rofelis.view


import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.easppb.rofelis.R
import com.easppb.rofelis.model.DescRestaurant
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.constants.Style
import com.mapbox.mapboxsdk.maps.MapView


class DetailActivity : AppCompatActivity() {
    companion object {
        const val ID_RESTAURANT = "id_restaurant"
    }

    @Override
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.restaurant_detail)

        val toolbar: Toolbar = findViewById(R.id.detail_toolbar)
        setSupportActionBar(toolbar)
        toolbar.logoDescription = resources.getString(R.string.app_name)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var det_image : ImageView = findViewById(R.id.detail_resto_img)
        var det_name : TextView = findViewById(R.id.detail_resto_name)
        var det_price : TextView = findViewById(R.id.detail_resto_price)
        var det_rating : RatingBar = findViewById(R.id.detail_resto_rating)
        var det_address : TextView = findViewById(R.id.detail_resto_alamat)
        var det_order : TextView = findViewById(R.id.detail_resto_order)

        val data = intent.getParcelableExtra<DescRestaurant>(ID_RESTAURANT)
        if(data != null){
            Glide.with(this)
                .load(data.thumb)
                .apply(RequestOptions().override(100, 100))
                .into(det_image)
                det_name.text = data.name
                det_price.text = data.average_cost_for_two + " " + data.currency
                det_rating.rating = data.UserRating.aggregate_rating.toFloat()
                det_order.text =  if(data.has_online_delivery=="0") {
                        "Order Online Tidak Tersedia!"
                    } else {
                        "Order Online Tersedia!"
                    }
                det_address.text = data.location.address + "\n" + "(Lat: " + data.location.latitude + ", Lon: " + data.location.longitude + ")"
        }

        Mapbox.getInstance(this, "pk.eyJ1IjoiZmVicml5b2dhYnMiLCJhIjoiY2tjazN0bTYxMTBnaDJxbnZ4dWlnY3FkdiJ9.dXWRlYCKUqnqvEVAISXNrA")
        val mapView = findViewById(R.id.mapView) as MapView
        mapView.setStyleUrl(Style.MAPBOX_STREETS)
        mapView.onCreate(savedInstanceState)


        /*
        val datasource2 = NetworkProvider.providesHttpAdapter().create(ReviewDatasource::class.java)
        datasource2.discoverReview().enqueue(object : Callback<Review> {
            override fun onResponse(call: Call<Review>, response: Response<Review>) {
                progressBar.visibility = View.GONE
                val results = response.body()?.rev

                val itemAdapter = findViewById<RecyclerView>(R.id.rv_review)
                itemAdapter.addItemDecoration(DividerItemDecoration(this@DetailActivity, DividerItemDecoration.VERTICAL))
                itemAdapter.adapter = ListReviewAdapter(results)
            }
            override fun onFailure(call: Call<Review>, t: Throwable) {
                Log.e(MainActivity::class.java.simpleName, "${t.printStackTrace()}")
            }
        })
        */
    }
}