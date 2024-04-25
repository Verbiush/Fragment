package com.example.fragments.fragments.welcome.welcome_adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments.R
import com.example.fragments.data.model.CharacterModel
import com.example.fragments.fragments.welcome.WelcomeFragment
import com.squareup.picasso.Picasso


class WelcomeAdapter(private val welcomeCharacterModel:List<CharacterModel> ):
     RecyclerView.Adapter<WelcomeAdapter.WelcomeViewHolder>() {

    private var onWelcomeClickListener: OnWelcomeClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WelcomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)

        return WelcomeViewHolder(view)
    }


     override fun onBindViewHolder(holder: WelcomeViewHolder, position:Int) {
        val characterModel = welcomeCharacterModel[position]

        holder.welcomeName.text = characterModel.name
        holder.welcomeSpecies.text = characterModel.species

         (characterModel.image.isNotEmpty())
             Picasso.with(holder.itemView.context)
                 .load(characterModel.image).into(holder.welcomeImage)

        holder.itemCharacterContainer.setOnClickListener {
        }
        holder.itemView.setOnClickListener {
            onWelcomeClickListener?.onWelcomeClick(position,characterModel)
        }
    }
     override fun getItemCount(): Int {
         return welcomeCharacterModel.size
     }
    class WelcomeViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val itemCharacterContainer: View = itemView.findViewById(R.id.itemCharacter)
        val welcomeImage: ImageView = itemView.findViewById(R.id.image)
        val welcomeName : TextView = itemView.findViewById(R.id.name)
        val welcomeSpecies: TextView = itemView.findViewById(R.id.species)

    }
     fun setOnClickListener(onClickListener: WelcomeFragment) {
         this.onWelcomeClickListener = onClickListener
     }
}