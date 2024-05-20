package com.example.fragments.data.repository



import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.model.model_location.LocationsModel
import com.example.fragments.data.network.LocationService

class LocationsRepository(val locationsService: LocationService) {
    suspend fun getLocationsFromApi():List<LocationModel>{
        val locationModel=locationsService.getLocations()

        val resultLocationModel=locationModel?.results
        if (resultLocationModel.isNullOrEmpty()){
            return mutableListOf<LocationModel>()
        }else{
            return resultLocationModel
        }
    }
    suspend fun getLocationDetailFromApi(id:Int): LocationModel? {
        val locationDetailModel=locationsService.getLocationDetail(id)
        return locationDetailModel
    }
}