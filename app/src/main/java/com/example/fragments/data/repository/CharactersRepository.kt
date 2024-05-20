package com.example.fragments.data.repository


import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.network.CharacterService

class CharactersRepository(private val characterService: CharacterService) {

   suspend fun getCharactersFromApi(page:Int):List<CharacterModel>{
      val characterModel=characterService.getCharacters(page)

       val resultCharacterModel=characterModel?.results
       if (resultCharacterModel.isNullOrEmpty()){

           return mutableListOf<CharacterModel>()
       }else{
           return resultCharacterModel
       }
    }

    suspend fun getCharacterDetailFromApi(id:Int): CharacterModel? {
        val characterDetailModel=characterService.getCharacterDetail(id)
        return characterDetailModel
    }
}