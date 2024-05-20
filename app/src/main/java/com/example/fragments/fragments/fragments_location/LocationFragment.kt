package com.example.fragments.fragments.fragments_location

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.data.network.LocationService
import com.example.fragments.data.network.RetrofitClient
import com.example.fragments.data.repository.LocationsRepository
import com.example.fragments.domain.GetLocationsUseCase
import com.example.fragments.fragments.fragments_location.location_adapter.LocationAdapter
import com.example.fragments.fragments.fragments_location.location_adapter.OnLocationClickListener
import com.example.fragments.fragments.fragments_location.location_view_model.LocationViewModel

class LocationFragment:Fragment(), OnLocationClickListener {
    private  var locationListRecycle: RecyclerView?=null
    private var locationViewModel: LocationViewModel? = null
    private var locationAdapter: LocationAdapter?=null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_location, container, false);

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationListRecycle=view.findViewById(R.id.recycleLocation)
        locationListRecycle?.layoutManager = LinearLayoutManager(context)

        initLocationViewModel()

        locationViewModel?.returnListLocationModel?.observe(viewLifecycleOwner) { list ->


            locationAdapter = LocationAdapter(list)
            locationListRecycle?.adapter = locationAdapter

            locationAdapter?.setOnClickListener(this)

            Log.d("location viewModel",list.toString())
        }

        locationViewModel?.getAllLocations()

    }
    private fun initLocationViewModel() {
        val locationService = LocationService(RetrofitClient.rickAndMortyApiClient)
        val locationsRepository = LocationsRepository(locationService)
        val locationsUseCase = GetLocationsUseCase(locationsRepository)

        locationViewModel = LocationViewModel(locationsUseCase)
    }
    override fun onWelcomeClick(position: Int, model: LocationModel) {

    }

}