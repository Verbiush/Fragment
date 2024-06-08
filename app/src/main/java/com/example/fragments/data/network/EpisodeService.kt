package com.example.fragments.data.network

import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.model.model_episode.EpisodesModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EpisodeService(val api: RickAndMortyApiClient) {

    suspend fun getEpisodes(): EpisodesModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllEpisodes()
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }
    }

    suspend fun getEpisodeDetail(id: Int): EpisodeModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getEpisode(id)
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }
    }

    suspend fun getEpisodesByCharacters(idEpisode: String): List<EpisodeModel>? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getEpisodeByCharacter(idEpisode)
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            null
        }
    }
}