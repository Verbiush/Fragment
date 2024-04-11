package com.example.fragments.data.network

import com.example.fragments.data.model.CharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService(private val api: RickAndMortyApiClient) {

    suspend fun getCharacters(): CharactersModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllCharacters(1)
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }

    }

}