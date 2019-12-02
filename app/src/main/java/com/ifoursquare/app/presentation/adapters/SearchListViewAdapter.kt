package com.ifoursquare.app.presentation.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifoursquare.app.R
import com.ifoursquare.app.data.model.venues.Venue

class SearchListViewAdapter : RecyclerView.Adapter<SearchListViewAdapter.ViewHolderImpl>() {

    private var dataSet: ArrayList<Venue> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImpl {
        val view = LayoutInflater.from(parent.context as Activity)
            .inflate(R.layout.list_view_row_item, parent, false)

         return ViewHolderImpl(view)
    }

    override fun getItemCount(): Int {

        return if(dataSet!=null) return dataSet.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderImpl, position: Int) {
        with(holder) {
            venueTitle.text = dataSet[position].name
            venueArea.text = dataSet[position].location.city

            if(dataSet[position].categories.isNotEmpty()) {
            val category =  dataSet[position].categories[0]
            category?.let {
                venueType.text = it.shortName
                //Glide.with(itemView.context).load((Uri.parse(it.icon.get64x64SizedImage()))).into(venueImage)
            }}
        }
    }

    fun updateData(dataSets: List<Venue>?) {
        this.dataSet = ArrayList(dataSets!!)
    }


    inner class ViewHolderImpl(view: View) : RecyclerView.ViewHolder(view) {
        var venueTitle: TextView = view.findViewById(R.id.title_venue)
        var venueImage: ImageView = view.findViewById(R.id.venue_img_view)
        var venueType: TextView = view.findViewById(R.id.venue_type_label)
        var venueArea: TextView = view.findViewById(R.id.venue_area_label)


    }
}

