package com.example.fragments.fragments.fragments_character.detail.location_adapter

import com.example.fragments.data.model.model_character.CharacterModel

interface OnDetailClickListener {
    fun onDetailClick(position: Int, model: CharacterModel)
}