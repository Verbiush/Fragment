package com.example.fragments.fragments.fragments_character.welcome.welcome_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class WelcomeViewModel(private val getCharactersUseCase: GetCharactersUseCase):ViewModel()
{
    val returnListCharacterModel = MutableLiveData<List<CharacterModel>>()
    val returnIdCharacterModel = MutableLiveData<CharacterModel>()

    fun getAllCharacters(){
        viewModelScope.launch {
            val tempCharacterID=returnIdCharacterModel
           val characterList= getCharactersUseCase.getAllCharacters(1)
            tempCharacterID.value?.id
            returnListCharacterModel.postValue(characterList)
        }

    }


}