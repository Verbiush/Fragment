package com.example.fragments.fragments.fragments_location.location_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.model_location.LocationModel
import com.example.fragments.fragments.fragments_location.LocationFragment


class LocationAdapter(private val locationModel:List<LocationModel>):
RecyclerView.Adapter<LocationAdapter.LocationViewHolder>(){

    private var onLocationClickListener: OnLocationClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location, parent, false)

        return LocationViewHolder(view)
    }


    override fun onBindViewHolder(holder: LocationViewHolder, position:Int) {
        val locationModel = locationModel[position]

        holder.locationName.text = locationModel.name
        holder.locationType.text = locationModel.type

        holder.itemLocationContainer.setOnClickListener {
        }
        holder.itemView.setOnClickListener {
            onLocationClickListener?.onWelcomeClick(position,locationModel)
        }
    }
    override fun getItemCount(): Int {
        return locationModel.size
    }
    class LocationViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemLocationContainer: View = itemView.findViewById(R.id.itemLocation)
        val locationName : TextView = itemView.findViewById(R.id.name)
        val locationType: TextView = itemView.findViewById(R.id.type)

    }
    fun setOnClickListener(onClickListener: LocationFragment) {
        this.onLocationClickListener = onClickListener
    }
}