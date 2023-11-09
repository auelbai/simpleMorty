package com.example.simplemorty.data.room

import androidx.lifecycle.LiveData
import com.example.simplemorty.domain.CharacterInfo
import com.example.simplemorty.domain.CharactersRepository

class RepositoryImpl: CharactersRepository {


    override suspend fun addCharacter(characterInfo: CharacterInfo) {

    }

    override suspend fun deleteCharacter(characterInfo: CharacterInfo) {
        TODO("Not yet implemented")
    }

    override suspend fun getCharacterById(characterId: Int): CharacterInfo {
        TODO("Not yet implemented")
    }

    override fun getListCharacters(): LiveData<List<CharacterInfo>> {
        TODO("Not yet implemented")
    }
}