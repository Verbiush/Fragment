package com.example.fragments.domain

import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.repository.CharactersRepository

class GetCharactersDetailUseCase(private val charactersRepository: CharactersRepository) {

    suspend fun getAllDetailCharacters(id: Int): CharacterModel? {


        return charactersRepository.getCharacterDetailFromApi(id)
    }
}