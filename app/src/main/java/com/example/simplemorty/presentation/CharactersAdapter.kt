package com.example.simplemorty.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.simplemorty.databinding.ItemCharacterPreviewBinding
import com.example.simplemorty.model.GetCharacterByIdResponse

class CharactersAdapter:
    PagingDataAdapter<GetCharacterByIdResponse, CharacterItemViewHolder>(CharactersDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ItemCharacterPreviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.itemName.text = item?.name
        holder.binding.itemStatus.text = item?.status
        Glide.with(holder.itemView).load(item?.image).into(holder.binding.itemCharacterImg)
    }
}