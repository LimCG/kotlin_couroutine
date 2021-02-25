package com.example.kotlincoroutinemvvm.network.models

import java.io.Serializable

data class Data(
    val data : List<ExchangeRate>
) : Serializable
