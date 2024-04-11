package com.example.fragments.data.network

import com.example.fragments.data.model.CharactersModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiClient {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharactersModel>
}