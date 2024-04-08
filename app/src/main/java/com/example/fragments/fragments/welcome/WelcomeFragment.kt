package com.example.fragments.fragments.welcome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragments.R
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragments.fragments.welcome.welcome_view_model.WelcomeViewModel

class WelcomeFragment:Fragment() {
    var buttonFragment:Button?=null
    private val args:WelcomeFragmentArgs by navArgs()
    private var welcomeViewModel:WelcomeViewModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonFragment=view.findViewById(R.id.buttonFragment)
        buttonFragment?.setOnClickListener {

            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToDetail(1))

        }
        val id=args.caneloId
        Log.d("CaneloContent",id.toString())

        welcomeViewModel=WelcomeViewModel()
        welcomeViewModel?.hi()

        welcomeViewModel?.sumResult?.observe(viewLifecycleOwner) {
            Log.d("Suma",it.toString())

            }
        welcomeViewModel?.sum(4,2)


    }
}



