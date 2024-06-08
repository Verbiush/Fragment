package com.example.fragments.data.repository

import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.model.model_episode.EpisodesModel
import com.example.fragments.data.network.EpisodeService

class EpisodesRepository(val episodeService: EpisodeService) {

    suspend fun getEpisodesFromApi(): List<EpisodeModel> {

        val episodesModel = episodeService.getEpisodes()
        val resultEpisodesModel = episodesModel?.results

        if (resultEpisodesModel.isNullOrEmpty()) {
            return mutableListOf<EpisodeModel>()
        } else {
            return resultEpisodesModel
        }
    }

    suspend fun getEpisodeDetailFromApi(id: Int): EpisodeModel? {
        val episodeDetailModel = episodeService.getEpisodeDetail(id)
        return episodeDetailModel
    }

    suspend fun getEpisodesByCharacters(idEpisodes:String): List<EpisodeModel> {

        val episodesModel = episodeService.getEpisodesByCharacters(idEpisodes)


        if (episodesModel.isNullOrEmpty()) {
            return mutableListOf<EpisodeModel>()
        } else {
            return episodesModel
        }
    }


}