package com.example.Yelp_Clone

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class Rv_Adapter (val context: Context, val restaurants :List<YelpRestaurant>) :RecyclerView.Adapter<Rv_Adapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant, parent, false))
    }

    override fun getItemCount() = restaurants.size


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val restaurants =restaurants[position]
      holder.tvName.text=restaurants.name
      holder.ratingBar.rating=restaurants.rating.toFloat()
        holder.tvNumReviews.text="${restaurants.numReviews} Reviews"
        holder.tvAddress.text=restaurants.location.address
        holder.tvCategory.text=restaurants.categories[0].title
        holder.tvDistance.text=restaurants.displayDistance()
        holder.tvPrice.text=restaurants.price
        val radius = 30; // corner radius, higher value = more rounded
        val margin = 10; // crop margin, set to 0 for corners with no crop
     // Glide.with(context).load(restaurants.imageUrl).apply(RequestOptions().transform(CenterCrop())).into(holder.imageView)
      //  Glide.with(context).load(restaurants.imageUrl).centerCrop().into(holder.imageView)
        Glide.with(context).load(restaurants.imageUrl).apply(RequestOptions()
            .transform(CenterCrop()
                ,RoundedCorners(20)))
            .into(holder.imageView)

    }

    inner class ViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView) {
       val tvName =itemView.findViewById<TextView>(R.id.tvName)
       val ratingBar =itemView.findViewById<RatingBar>(R.id.ratingBar)
       val tvNumReviews =itemView.findViewById<TextView>(R.id.tvNumReviews)
       val tvAddress =itemView.findViewById<TextView>(R.id.tvAddress)
       val tvCategory =itemView.findViewById<TextView>(R.id.tvCategory)
       val tvDistance =itemView.findViewById<TextView>(R.id.tvDistance)
       val tvPrice =itemView.findViewById<TextView>(R.id.tvPrice)
       val imageView  =itemView.findViewById<ImageView>(R.id.imageView)



    }
}
