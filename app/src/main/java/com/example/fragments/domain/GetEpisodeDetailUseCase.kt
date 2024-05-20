package com.example.fragments.domain

import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.repository.EpisodesRepository
import com.example.fragments.data.repository.LocationsRepository

class GetEpisodeDetailUseCase (val episodesRepository: EpisodesRepository) {

    suspend fun getAllDetailEpisode(id: Int): EpisodeModel? {


        return episodesRepository.getEpisodeDetailFromApi(id)
    }
}