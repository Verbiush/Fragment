package com.example.fragments.data.network

import com.example.fragments.data.model.model_character.CharactersModel
import com.example.fragments.data.model.model_location.LocationsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiClient {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharactersModel>

    @GET("location")
    suspend fun getAllLocations(): Response<LocationsModel>
}