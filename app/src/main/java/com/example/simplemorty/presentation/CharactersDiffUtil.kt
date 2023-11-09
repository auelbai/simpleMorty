package com.example.simplemorty.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse

class CharactersDiffUtil: DiffUtil.ItemCallback<GetCharacterByIdResponse>() {
    override fun areItemsTheSame(
        oldItem: GetCharacterByIdResponse,
        newItem: GetCharacterByIdResponse
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: GetCharacterByIdResponse,
        newItem: GetCharacterByIdResponse
    ): Boolean {
        return oldItem == newItem
    }
}