package com.ifoursquare.app.presentation.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ifoursquare.app.R
import com.ifoursquare.app.data.model.Venue

class SearchListViewAdapter  : RecyclerView.Adapter<SearchListViewAdapter.ViewHolderImpl>() {

    private var dataSet: ArrayList<Venue> =  arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImpl {
        val view = LayoutInflater.from(parent.context as Activity)
            .inflate(R.layout.list_view_row_item, parent, false)
        return ViewHolderImpl(view)
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolderImpl, position: Int) {
        holder.venueTitle.text = dataSet[position].name

    }

    fun updateData(dataSets: List<Venue>?) {
        this.dataSet = ArrayList(dataSets!!)
    }


    inner class ViewHolderImpl(view: View) : RecyclerView.ViewHolder(view) {
        var venueTitle :TextView = view.findViewById(R.id.title_venue)
    }
}

