package com.example.fragments.fragments.fragments_character.detail.detail_view_model


import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.R
import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.data.model.model_episode.EpisodesModel
import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.domain.GetCharactersDetailUseCase
import com.example.fragments.domain.GetEpisodeDetailUseCase
import com.example.fragments.domain.GetEpisodesUseCase
import com.example.fragments.domain.GetLocationDetailUseCase
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getDetailCharactersUseCase: GetCharactersDetailUseCase,
    private val getEpisodeUseCase: GetEpisodesUseCase) : ViewModel() {

    val returnDetailCharacterModel = MutableLiveData<CharacterModel?>()
    val returnEpisodesListModel = MutableLiveData<List<EpisodeModel?>>()

    fun getAllDetailCharacters() {
        viewModelScope.launch {
            val characterDetail = getDetailCharactersUseCase.getAllDetailCharacters(2)


            returnDetailCharacterModel.postValue(characterDetail)
        }
    }
    fun getAllEpisodes() {
        viewModelScope.launch {
            val episodeList =getEpisodeUseCase.getAllEpisodes()
            episodeList.forEach { characterUrl ->

                returnEpisodesListModel.postValue(episodeList)

            }

        }
    }
}












