package com.example.fragments.data.model.model_character

data class CharacterModel(
    val id:Int,
    val name:String,
    val status:String,
    val species:String,
    val type:String,
    val gender:String,
    val origin: CharacterOriginModel,
    val location: CharacterLocationModel,
    val image:String,
    val episode:List<String>,
    val url:String)






