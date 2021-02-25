package com.example.kotlincoroutinemvvm.network.remotedata

import com.example.kotlincoroutinemvvm.network.errors.ServerError
import com.example.kotlincoroutinemvvm.network.models.Data
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RemoteDataSource {

    @Headers("Accept: application/vnd.BNM.API.v1+json")
    @GET("/public/exchange-rate")
    suspend fun getExchangeRates() : NetworkResponse<Data, ServerError>
}