package com.tuwaiq.restandretrofit.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tuwaiq.restandretrofit.R
import com.tuwaiq.restandretrofit.data.network.models.FlickrListPhotos
import com.tuwaiq.restandretrofit.data.network.models.FlickrPhoto

class FlickAdapter(val photosData: List<FlickrPhoto> ) : RecyclerView.Adapter<CustomHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.flickr_recycleview_item,parent, false)
        return CustomHolder(view)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return photosData.size
    }

}

class CustomHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTV: TextView= itemView.findViewById(R.id.tvFlickr)


}
