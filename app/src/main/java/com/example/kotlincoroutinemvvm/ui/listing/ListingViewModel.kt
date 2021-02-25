package com.example.kotlincoroutinemvvm.ui.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.kotlincoroutinemvvm.network.NetworkManager
import com.example.kotlincoroutinemvvm.network.models.ExchangeRate
import com.haroldadmin.cnradapter.NetworkResponse

class ListingViewModel : ViewModel() {

    val data = liveData<Resource<List<ExchangeRate>>> {

        emit(Resource.Loading())

        val response = NetworkManager.remoteDataSource.getExchangeRates()

        when(response)
        {
            is NetworkResponse.Success -> {
                emit(Resource.Success(response.body.data))
            }
            is NetworkResponse.NetworkError -> {
                emit(Resource.Error(response.error.message))
            }
            is NetworkResponse.ServerError -> {
                emit(Resource.Error(response.body?.message))
            }
            is NetworkResponse.UnknownError -> {
                emit(Resource.Error(response.error.message))
            }
        }

    }
}