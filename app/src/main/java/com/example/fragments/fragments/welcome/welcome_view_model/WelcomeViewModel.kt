package com.example.fragments.fragments.welcome.welcome_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragments.data.model.CharacterModel
import com.example.fragments.domain.GetCharactersUseCase
import kotlinx.coroutines.launch

class WelcomeViewModel(private val getCharactersUseCase: GetCharactersUseCase):ViewModel()
{
    val returnListCharacterModel = MutableLiveData<List<CharacterModel>>()

    fun getAllCharacters(){
        viewModelScope.launch {
           val characterList= getCharactersUseCase.getAllCharacters()
            returnListCharacterModel.postValue(characterList)
        }

    }

}