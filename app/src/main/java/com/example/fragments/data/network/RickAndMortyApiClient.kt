package com.example.fragments.data.network

import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.model.model_character.CharactersModel
import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.model.model_episode.EpisodesModel
import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.model.model_location.LocationsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiClient {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int): Response<CharactersModel>

    @GET("character/{id}")
    suspend fun getAllCharacterDetail(@Path("id") id:Int): Response<CharacterModel>


    @GET("location")
    suspend fun getAllLocations(): Response<LocationsModel>

    @GET("location/{id}")
    suspend fun getAllLocationDetail(@Path("id") id:Int): Response<LocationModel>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<EpisodesModel>

    @GET("episode/{id}")
    suspend fun getAllEpisodeDetail(@Path("id") id:Int): Response<EpisodeModel>


}