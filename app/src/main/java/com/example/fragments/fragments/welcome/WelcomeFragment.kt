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
import com.example.fragments.data.network.CharacterService
import com.example.fragments.data.network.RetrofitClient
import com.example.fragments.data.repository.CharactersRepository
import com.example.fragments.domain.GetCharactersUseCase
import com.example.fragments.fragments.welcome.welcome_view_model.WelcomeViewModel

class WelcomeFragment:Fragment() {

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
      initWelcomeViewModel()

    }
    private fun initWelcomeViewModel() {
        val characterService=CharacterService(RetrofitClient.rickAndMortyApiClient)
        val charactersRepository=CharactersRepository(characterService)
        val charactersUseCase=GetCharactersUseCase(charactersRepository)

        welcomeViewModel=WelcomeViewModel(charactersUseCase)

    }
}



