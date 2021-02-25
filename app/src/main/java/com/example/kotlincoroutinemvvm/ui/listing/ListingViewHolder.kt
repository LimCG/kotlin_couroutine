package com.example.kotlincoroutinemvvm.ui.listing

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinemvvm.databinding.ListingViewBinding
import com.example.kotlincoroutinemvvm.network.models.ExchangeRate

class ListingViewHolder(private var listingViewBinding: ListingViewBinding) : RecyclerView.ViewHolder(listingViewBinding.root) {

    fun bindView(data : ExchangeRate) = listingViewBinding.apply {
        this.txtName.text = data.currency_code
    }

}