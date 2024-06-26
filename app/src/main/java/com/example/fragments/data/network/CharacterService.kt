package com.example.fragments.data.network

import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.model.model_character.CharactersModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterService(private val api: RickAndMortyApiClient) {

    suspend fun getCharacters(page:Int): CharactersModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllCharacters(page)
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }

    }

    suspend fun getCharacterDetail(id:Int): CharacterModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllCharacterDetail(2)
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }

    }

}