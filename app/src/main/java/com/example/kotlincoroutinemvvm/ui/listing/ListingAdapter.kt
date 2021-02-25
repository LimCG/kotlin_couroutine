package com.example.kotlincoroutinemvvm.ui.listing

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinemvvm.databinding.ListingViewBinding
import com.example.kotlincoroutinemvvm.network.models.ExchangeRate

class ListingAdapter(context : Context, val dataList : List<ExchangeRate>) : RecyclerView.Adapter<ListingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val listingViewBinding = ListingViewBinding.inflate(inflater, parent, false)
        return ListingViewHolder(listingViewBinding)
    }

    override fun onBindViewHolder(holder: ListingViewHolder, position: Int) {
        holder.bindView(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }


}