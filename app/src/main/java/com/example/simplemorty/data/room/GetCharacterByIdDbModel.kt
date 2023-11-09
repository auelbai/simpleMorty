package com.example.simplemorty.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.simplemorty.data.network.model.Location
import com.example.simplemorty.data.network.model.Origin

@Entity(tableName = "simple_morty")
data class GetCharacterByIdDbModel(
    val gender: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String
) {
}