package com.example.fragments.data.model.model_episode

data class EpisodeModel (
    val id:Int,
    val name:String,
    val air_date:String,
    val episode:String,
    val characters:List<String>,
    val url:String
)