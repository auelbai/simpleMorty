package com.example.simplemorty.domain

import androidx.room.PrimaryKey
import com.example.simplemorty.data.network.model.Location
import com.example.simplemorty.data.network.model.Origin

data class CharacterInfo(
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String
) {
}