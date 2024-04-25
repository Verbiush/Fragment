package com.example.fragments.fragments.welcome

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.CharacterModel
import com.example.fragments.fragments.welcome.welcome_adapter.OnWelcomeClickListener
import com.example.fragments.data.network.CharacterService
import com.example.fragments.data.network.RetrofitClient
import com.example.fragments.data.repository.CharactersRepository
import com.example.fragments.domain.GetCharactersUseCase
import com.example.fragments.fragments.welcome.welcome_adapter.WelcomeAdapter
import com.example.fragments.fragments.welcome.welcome_view_model.WelcomeViewModel

class WelcomeFragment : Fragment(), OnWelcomeClickListener{
    private  var characterListRecycle:RecyclerView?=null
    private var welcomeViewModel: WelcomeViewModel? = null
    private var characterAdapter:WelcomeAdapter?=null


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
        characterListRecycle=view.findViewById(R.id.recycleWelcome)
        characterListRecycle?.layoutManager = GridLayoutManager(context,2)

        initWelcomeViewModel()

        welcomeViewModel?.returnListCharacterModel?.observe(viewLifecycleOwner) { list ->


            characterAdapter =WelcomeAdapter(list)
            characterListRecycle?.adapter = characterAdapter

            characterAdapter?.setOnClickListener(this)

            Log.d("character viewModel",list.toString())
        }

        welcomeViewModel?.getAllCharacters()

    }


    private fun initWelcomeViewModel() {
        val characterService = CharacterService(RetrofitClient.rickAndMortyApiClient)
        val charactersRepository = CharactersRepository(characterService)
        val charactersUseCase = GetCharactersUseCase(charactersRepository)

        welcomeViewModel = WelcomeViewModel(charactersUseCase)
    }

    override fun onWelcomeClick(position: Int, model: CharacterModel) {

    }



}







