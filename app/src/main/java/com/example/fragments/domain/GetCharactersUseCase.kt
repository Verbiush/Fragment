package com.example.fragments.domain

import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.repository.CharactersRepository

class GetCharactersUseCase(private val charatersRepository: CharactersRepository) {
   suspend fun getAllCharacters(page:Int):List<CharacterModel>{

       return charatersRepository.getCharactersFromApi(page)
    }
}