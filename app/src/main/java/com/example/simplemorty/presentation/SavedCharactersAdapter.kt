package com.example.simplemorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.simplemorty.databinding.ItemCharacterPreviewBinding
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.domain.CharacterInfo

class SavedCharactersAdapter:
    ListAdapter<CharacterInfo, CharacterItemViewHolder>(SavedCharactersDiffUtil()) {

    var onItemClickListener: ((CharacterInfo) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ItemCharacterPreviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val character = getItem(position)
        holder.binding.itemName.text = character?.name
        holder.binding.itemStatus.text = character?.status
        Glide.with(holder.itemView).load(character?.image).into(holder.binding.itemCharacterImg)

        holder.itemView.setOnClickListener {
            if (character != null) {
                onItemClickListener?.invoke(character)
            }
        }
    }
}