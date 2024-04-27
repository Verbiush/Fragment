package com.example.fragments.fragments.fragments_character.content.content_view_model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContentViewModel:ViewModel() {
    val multiResult = MutableLiveData<Int>()

    fun multiplication(numberOne:Int,numberTwo: Int){
        var multi= numberOne*numberTwo
        multiResult.postValue(multi)
    }
}