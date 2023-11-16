package com.example.simplemorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.domain.CharacterInfo

class SavedCharactersDiffUtil: DiffUtil.ItemCallback<CharacterInfo>() {
    override fun areItemsTheSame(
        oldItem: CharacterInfo,
        newItem: CharacterInfo
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: CharacterInfo,
        newItem: CharacterInfo
    ): Boolean {
        return oldItem == newItem
    }
}