package com.example.fragments.fragments.fragments_character.detail


import com.example.fragments.data.picasso.CircleTransform
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.model_character.CharacterModel
import com.example.fragments.data.network.CharacterService
import com.example.fragments.data.network.EpisodeService
import com.example.fragments.data.network.RetrofitClient
import com.example.fragments.data.repository.CharactersRepository
import com.example.fragments.data.repository.EpisodesRepository
import com.example.fragments.domain.GetCharactersDetailUseCase
import com.example.fragments.domain.GetEpisodesUseCase
import com.example.fragments.fragments.fragments_character.detail.detail_episode_by_character_adapter.EpisodeByCharacterAdapter
import com.example.fragments.fragments.fragments_character.detail.detail_view_model.DetailViewModel
import com.example.fragments.fragments.fragments_character.detail.location_adapter.OnDetailClickListener
import com.squareup.picasso.Picasso


class DetailFragment() : Fragment(), OnDetailClickListener {

    private var detailImage: ImageView? = null
    private var detailName: TextView? = null
    private var detailSpecies: TextView? = null
    private var detailStatus: TextView? = null
    private var detailGender: TextView? = null
    private var detailEpisode: TextView? = null
    private var detailLocation: TextView? = null

    private val args: DetailFragmentArgs by navArgs()
    private var detailViewModel: DetailViewModel? = null
    private var containerItemDetail: LinearLayout? = null
    private var episodeByCharacterAdapter: EpisodeByCharacterAdapter? = null
    private var episodeListRecycle: RecyclerView? = null


    private fun init() {

        detailImage = view?.findViewById(R.id.image)
        detailName = view?.findViewById(R.id.name)
        detailSpecies = view?.findViewById(R.id.species)
        detailStatus = view?.findViewById(R.id.status)
        detailLocation = view?.findViewById(R.id.location)
        detailGender = view?.findViewById(R.id.gender)
        detailEpisode = view?.findViewById(R.id.size)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        containerItemDetail = view?.findViewById(R.id.itemDetail)
        episodeListRecycle = view?.findViewById(R.id.recycle_episode_by_character)


        initDetailViewModel()
        init()

        detailViewModel?.returnDetailCharacterModel?.observe(viewLifecycleOwner) { detail ->

            Picasso.with(context).load(detail?.image)
                .transform(CircleTransform())
                .into(detailImage)

            detailName?.text = detail?.name
            detailSpecies?.text = detail?.species
            detailStatus?.text = detail?.status
            detailLocation?.text = detail?.location?.name.toString()
            detailGender?.text = detail?.gender

            Log.d("character 1", detail.toString())
        }

        detailViewModel?.returnEpisodesListModel?.observe(viewLifecycleOwner) { episode ->

            episodeByCharacterAdapter = EpisodeByCharacterAdapter(episode)
            episodeListRecycle?.adapter = episodeByCharacterAdapter
            detailEpisode?.text = episode?.size.toString()


            Log.d("episodes 1", episode.toString())

        }

        detailViewModel?.getAllDetailCharacters(2)


    }

    private fun initDetailViewModel() {
        val characterService = CharacterService(RetrofitClient.rickAndMortyApiClient)
        val charactersRepository = CharactersRepository(characterService)
        val charactersDetailUseCase = GetCharactersDetailUseCase(charactersRepository)

        val episodeService = EpisodeService(RetrofitClient.rickAndMortyApiClient)
        val episodesRepository = EpisodesRepository(episodeService)
        val episodeUseCase = GetEpisodesUseCase(episodesRepository)


        detailViewModel = DetailViewModel(charactersDetailUseCase, episodeUseCase)
    }

    override fun onDetailClick(position: Int, model: CharacterModel) {

    }

}

