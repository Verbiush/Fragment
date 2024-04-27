package com.example.fragments.fragments.fragments_location.location_view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.domain.GetLocationsUseCase
import kotlinx.coroutines.launch

class LocationViewModel(private val getLocationsUseCase: GetLocationsUseCase): ViewModel() {
    val returnListLocationModel = MutableLiveData<List<LocationModel>>()

    fun getAllLocations(){
        viewModelScope.launch {
            val locationList= getLocationsUseCase.getAllLocations()
            returnListLocationModel.postValue(locationList)
        }

    }
}