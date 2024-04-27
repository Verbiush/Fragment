package com.example.fragments.fragments.fragments_location.location_adapter

import com.example.fragments.data.model.model_location.LocationModel

interface OnLocationClickListener {
    fun onWelcomeClick(position: Int, model: LocationModel)
}