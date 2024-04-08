package com.example.fragments.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments.R
import com.example.fragments.fragments.detail.detail_view_model.DetailViewModel


class DetailFragment:Fragment() {
    var buttonFragmentDetail: Button?=null
    private var detailViewModel: DetailViewModel?=null

    private val args:DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFragmentDetail=view.findViewById(R.id.buttonDetail)
        buttonFragmentDetail?.setOnClickListener {

            findNavController().navigate(DetailFragmentDirections.actionDetailToContent(2))
        }
      //  DetailFragmentArgs.fromBundle(requireArguments()).caneloId
        val id=args.caneloId
        Log.d("CaneloDetail",id.toString())


        detailViewModel= DetailViewModel()
        detailViewModel?.subResult?.observe(viewLifecycleOwner) {
            Log.d("Resta",it.toString())

        }
        detailViewModel?.subtraction(10,2)

    }

}