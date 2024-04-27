package com.example.fragments.data.model.model_location

import android.hardware.biometrics.BiometricManager.Strings
import com.example.fragments.data.model.model_character.CharacterModel

data class LocationModel (
    val id:Int,
    val name:String,
    val type:String,
    val dimension:String,
    val residents:List<String>,
    val url:String)