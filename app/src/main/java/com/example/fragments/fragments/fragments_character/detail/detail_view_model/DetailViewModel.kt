package com.example.fragments.fragments.fragments_character.detail.detail_view_model


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.domain.GetCharactersDetailUseCase
import com.example.fragments.domain.GetEpisodesUseCase

import kotlinx.coroutines.launch

class DetailViewModel(
    private val getDetailCharactersUseCase: GetCharactersDetailUseCase,
    private val getEpisodeUseCase: GetEpisodesUseCase
) : ViewModel() {

    val returnDetailCharacterModel = MutableLiveData<CharacterModel?>()
    val returnEpisodesListModel = MutableLiveData<List<EpisodeModel?>>()

    fun getAllDetailCharacters(id:Int) {
        viewModelScope.launch {

            val characterDetail = getDetailCharactersUseCase.getAllDetailCharacters(2)
            val listTempIdEpisode = mutableListOf<String>()

            characterDetail?.episode?.forEach { episode ->
                Log.d("id", episode)

                val tempEpisode = episode.split("/")
                val idEpisode = tempEpisode.last()
                listTempIdEpisode.add(idEpisode)
            }
            val idEpisodesString= listTempIdEpisode.joinToString()
            val listEpisodeCharacters = getEpisodeUseCase.getEpisodesByCharacters(idEpisodesString)

            Log.d("List idEpisode", listEpisodeCharacters.toString())


            returnEpisodesListModel.postValue(listEpisodeCharacters)
            returnDetailCharacterModel.postValue(characterDetail)

        }
    }

    fun getNavigationCharacterID(): Int? {
        return returnDetailCharacterModel.value?.id
    }

}












