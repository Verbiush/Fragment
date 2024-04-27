package com.example.fragments.fragments.fragments_character.detail.detail_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailViewModel:ViewModel() {
    val subResult = MutableLiveData<Int>()

    fun subtraction(numberOne:Int,numberTwo: Int){
        var subt= numberOne-numberTwo
        subResult.postValue(subt)
    }
}