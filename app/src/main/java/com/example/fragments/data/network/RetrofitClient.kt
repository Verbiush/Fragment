package com.example.fragments.data.network
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val url = "https://rickandmortyapi.com/api/"

    val retrofitClient: Retrofit.Builder by lazy {

        val okhttpClient = OkHttpClient.Builder()

        Retrofit.Builder()
            .baseUrl(url)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val rickAndMortyApiClient: RickAndMortyApiClient by lazy {
        retrofitClient
            .build()
            .create(RickAndMortyApiClient::class.java)
    }
}