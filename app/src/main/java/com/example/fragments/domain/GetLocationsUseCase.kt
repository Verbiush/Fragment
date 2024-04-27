package com.example.fragments.domain


import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.repository.LocationsRepository

class GetLocationsUseCase(val locationsRepository: LocationsRepository) {
    suspend fun getAllLocations():List<LocationModel>{

        return locationsRepository.getLocationsFromApi()
    }
}