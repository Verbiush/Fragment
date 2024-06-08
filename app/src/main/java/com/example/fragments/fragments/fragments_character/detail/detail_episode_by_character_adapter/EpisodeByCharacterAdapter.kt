package com.example.fragments.fragments.fragments_character.detail.detail_episode_by_character_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.model_episode.EpisodeModel
import com.example.fragments.fragments.fragments_character.detail.DetailFragment
import com.example.fragments.fragments.fragments_character.welcome.welcome_adapter.OnWelcomeClickListener

class EpisodeByCharacterAdapter (private val episodeByCharacterModel:List<EpisodeModel?> ):
    RecyclerView.Adapter<EpisodeByCharacterAdapter.EpisodeByCharacterViewHolder>() {

    private var onWelcomeClickListener: OnWelcomeClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeByCharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_episode_by_character, parent, false)

        return EpisodeByCharacterViewHolder(view)
    }


    override fun onBindViewHolder(holder: EpisodeByCharacterViewHolder, position:Int) {
        val episodeModel = episodeByCharacterModel[position]

        holder.episodeName.text = episodeModel?.name
        holder.episodeSession.text = episodeModel?.episode


    }
    override fun getItemCount(): Int {
        return episodeByCharacterModel.size
    }
    class EpisodeByCharacterViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemEpisodeContainer: View = itemView.findViewById(R.id.item_episode_by_character)
        val episodeName : TextView = itemView.findViewById(R.id.name)
        val episodeSession: TextView = itemView.findViewById(R.id.episode)


    }
    fun setOnClickListener(onClickListener: DetailFragment) {

    }
}