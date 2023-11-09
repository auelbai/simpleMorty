package com.example.simplemorty.domain

import androidx.lifecycle.LiveData

interface CharactersRepository {

    suspend fun addCharacter(characterInfo: CharacterInfo)
    suspend fun deleteCharacter(characterInfo: CharacterInfo)
    suspend fun getCharacterById(characterId: Int): CharacterInfo
    fun getListCharacters(): LiveData<List<CharacterInfo>>
}