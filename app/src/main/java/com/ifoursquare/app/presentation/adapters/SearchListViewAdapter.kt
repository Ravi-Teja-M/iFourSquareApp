package com.ifoursquare.app.presentation.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifoursquare.app.R

class SearchListViewAdapter  : RecyclerView.Adapter<SearchListViewAdapter.ViewHolderImpl>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderImpl {
        val view = LayoutInflater.from(parent.context as Activity)
            .inflate(R.layout.list_view_row_item, parent, false)
        return ViewHolderImpl(view)
    }

    override fun getItemCount(): Int {

        return 20
    }

    override fun onBindViewHolder(holder: ViewHolderImpl, position: Int) {


    }


    inner class ViewHolderImpl(view: View) : RecyclerView.ViewHolder(view) {

    }
}

