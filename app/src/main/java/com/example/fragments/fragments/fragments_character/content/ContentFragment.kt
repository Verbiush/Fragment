package com.example.fragments.fragments.fragments_character.content

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
import com.example.fragments.fragments.fragments_character.content.content_view_model.ContentViewModel


class ContentFragment: Fragment() {
    var buttonFragmentReturn: Button?=null
    private val args:ContentFragmentArgs by navArgs()
    private var contentViewModel: ContentViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_content, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFragmentReturn=view.findViewById(R.id.buttonReturn)
        buttonFragmentReturn?.setOnClickListener {
            findNavController().navigate(ContentFragmentDirections.actionContentToWelcome(3))
        }
        val id=args.caneloId
        Log.d("CaneloContent",id.toString())

        contentViewModel= ContentViewModel()
        contentViewModel?.multiResult?.observe(viewLifecycleOwner) {
            Log.d("Multiplicacion",it.toString())

        }
        contentViewModel?.multiplication(9,3)
    }
}