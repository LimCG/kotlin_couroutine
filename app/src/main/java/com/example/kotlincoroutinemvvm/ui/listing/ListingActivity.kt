package com.example.kotlincoroutinemvvm.ui.listing

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincoroutinemvvm.databinding.ActivityListingBinding
import com.example.kotlincoroutinemvvm.network.models.ExchangeRate

class ListingActivity : AppCompatActivity() {

    private val viewModel: ListingViewModel by viewModels()
    private lateinit var activityListingBinding: ActivityListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityListingBinding = ActivityListingBinding.inflate(layoutInflater)
        setContentView(activityListingBinding.root)

        viewModel.data.observe(this, {

            when(it)
            {
                is Resource.Loading -> {
                    updateLoadingState(true)
                }

                is Resource.Success -> {
                    updateLoadingState(false)
                    updateData(it.data ?: emptyList())
                }

                is Resource.Error -> {
                    updateLoadingState(false)
                    showError(it.message)
                }

            }

        })
    }

    private fun updateLoadingState(isLoading: Boolean) {
        activityListingBinding.list.visibility = when {
            isLoading -> View.GONE
            else -> View.VISIBLE
        }

        activityListingBinding.listLoading.visibility = when {
            isLoading -> View.VISIBLE
            else -> View.GONE
        }
    }

    private fun updateData(dataList : List<ExchangeRate>)
    {
        activityListingBinding.list.apply {
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
            layoutManager = LinearLayoutManager(context)
            adapter = ListingAdapter(this@ListingActivity, dataList)

        }

    }

    private fun showError(errorMsg : String?)
    {
        Log.e("TAG", ""+errorMsg)
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }
}