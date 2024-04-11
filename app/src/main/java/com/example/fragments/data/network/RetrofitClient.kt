package com.example.fragments.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val url = "https://rickandmortyapi.com/api/"

    val retrofitClient: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val rickAndMortyApiClient: RickAndMortyApiClient by lazy {
        retrofitClient.create(RickAndMortyApiClient::class.java)
    }
}