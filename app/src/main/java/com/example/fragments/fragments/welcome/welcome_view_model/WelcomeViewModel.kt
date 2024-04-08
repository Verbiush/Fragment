package com.example.fragments.fragments.welcome.welcome_view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel:ViewModel() {
    val sumResult = MutableLiveData<Int>()
    fun hi(){
        Log.d("WelcomeVieModel","Primer ViewModel")
    }
    fun sum(numberUno:Int,numberDos: Int){
        var suma= numberUno+numberDos
        sumResult.postValue(suma)
    }
}