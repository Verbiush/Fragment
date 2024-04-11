package com.example.fragments.data.repository

import com.example.fragments.data.model.CharacterModel
import com.example.fragments.data.model.CharactersModel
import com.example.fragments.data.network.CharacterService

class CharactersRepository(private val characterService: CharacterService) {

   suspend fun getCharactersFromApi():List<CharacterModel>{
      val characterModel=characterService.getCharacters()

       val resultCharacterModel=characterModel?.results
       if (resultCharacterModel.isNullOrEmpty()){

           return mutableListOf<CharacterModel>()
       }else{
           return resultCharacterModel
       }
    }
}