package com.example.fragments.domain


import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.repository.LocationsRepository

class GetLocationDetailUseCase(val locationsRepository: LocationsRepository) {

    suspend fun getAllDetailLocation(id: Int): LocationModel? {


        return locationsRepository.getLocationDetailFromApi(id)
    }
}
