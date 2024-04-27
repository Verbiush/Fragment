package com.example.fragments.data.network


import android.util.Log
import com.example.fragments.data.model.model_location.LocationsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationService(val api:RickAndMortyApiClient ){
    suspend fun getLocations(): LocationsModel? {
        return try {
            withContext(Dispatchers.IO) {
                val response = api.getAllLocations()
                val responseBody = response.body()
                responseBody
            }
        } catch (exception: Exception) {
            Log.d("exception",exception.toString())
            null
        }

    }
}