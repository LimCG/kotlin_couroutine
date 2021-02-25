package com.example.kotlincoroutinemvvm.network

import com.example.kotlincoroutinemvvm.network.remotedata.RemoteDataSource
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private const val baseUrl = "api.bnm.gov.my"

    private val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setLenient()
            .create()

    private val client: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://$baseUrl")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }

    val remoteDataSource : RemoteDataSource by lazy {
        client.create(RemoteDataSource::class.java)
    }
}