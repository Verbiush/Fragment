package com.example.fragments.data.model.model_location

data class LocationModel (
    val id:Int,
    val name:String,
    val type:String,
    val dimension:String,
    val residents:List<String>,
    val url:String)