package com.example.simplemorty.domain

import androidx.lifecycle.LiveData
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse

interface CharactersRepository {

    suspend fun addCharacter(characterInfo: GetCharacterByIdResponse)
    suspend fun deleteCharacter(characterInfo: CharacterInfo)
    suspend fun getCharacterById(characterId: Int): CharacterInfo
    fun getListCharacters(): LiveData<List<CharacterInfo>>
}