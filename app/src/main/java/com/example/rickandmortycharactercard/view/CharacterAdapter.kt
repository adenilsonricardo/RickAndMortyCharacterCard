package com.example.rickandmortycharactercard.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortycharactercard.databinding.ListItemViewBinding
import com.example.rickandmortycharactercard.model.Characters
import com.example.rickandmortycharactercard.model.CharactersResponse
import com.squareup.picasso.Picasso

class CharacterAdapter (var list: MutableList<Characters>):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>(){

    class ViewHolder (val binding: ListItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun onBind(characters: Characters){
            binding.nameCharacter.text = characters.name
            binding.genderCharacter.text= characters.gender
            binding.specieCharacter.text= characters.species
            Picasso.get().load(characters.image).into(binding.imageCharacter)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val characters = list[position]
        holder.onBind(characters)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(newList: MutableList<Characters>) {
        this.list.removeAll(list)
        if (newList != null) {
            this.list = newList
        }
        notifyDataSetChanged()
    }
}