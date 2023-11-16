package com.example.simplemorty.data.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.domain.CharacterInfo
import com.example.simplemorty.domain.CharactersRepository

class RepositoryImpl(application: Application): CharactersRepository {

    private val mapper = Mapper()
    private val charactersDao = AppDatabase.getInstance(application).characterDao()

    override suspend fun addCharacter(characterInfo: GetCharacterByIdResponse) {
        charactersDao.addCharacter(mapper.mapCharacterInfoNetworkToCharacterInfoDbModel(characterInfo))
    }

    override suspend fun deleteCharacter(characterInfo: CharacterInfo) {
        charactersDao.deleteCharacter(mapper.mapCharacterInfoEntityToCharacterInfoDbModel(characterInfo))
    }

    override suspend fun getCharacterById(characterId: Int): CharacterInfo {
        return mapper.mapCharacterInfoDbModelToCharacterInfoEntity(charactersDao.getCharacterById(characterId))
    }

    override fun getListCharacters(): LiveData<List<CharacterInfo>> {
        return charactersDao.getAllCharacters().map {
            mapper.mapListDbModelToListEntity(it)
        }
    }
}