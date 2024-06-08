package com.example.fragments.domain

import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.repository.EpisodesRepository


class GetEpisodesUseCase(val episodesRepository: EpisodesRepository) {
    suspend fun getAllEpisodes(): List<EpisodeModel> {

        return episodesRepository.getEpisodesFromApi()
    }

    suspend fun getEpisodesByCharacters(idEpisodes:String): List<EpisodeModel> {

        return episodesRepository.getEpisodesByCharacters(idEpisodes)
    }
}

