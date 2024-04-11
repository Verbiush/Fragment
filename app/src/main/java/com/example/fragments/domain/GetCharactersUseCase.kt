package com.example.fragments.domain

import com.example.fragments.data.model.CharacterModel
import com.example.fragments.data.repository.CharactersRepository

class GetCharactersUseCase(private val charatersRepository: CharactersRepository) {
   suspend fun getAllCharacters():List<CharacterModel>{

       return charatersRepository.getCharactersFromApi()
    }
}