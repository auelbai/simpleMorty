package com.example.simplemorty.data.room

import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.domain.CharacterInfo

class Mapper {
    fun mapCharacterInfoNetworkToCharacterInfoDbModel(
        characterResponse: GetCharacterByIdResponse
    ): GetCharacterByIdDbModel {
        return GetCharacterByIdDbModel(
            gender = characterResponse.gender,
            id = characterResponse.id,
            image = characterResponse.image,
            name = characterResponse.name,
            origin = characterResponse.origin,
            species = characterResponse.species,
            status = characterResponse.status
        )
    }
    fun mapCharacterInfoDbModelToCharacterInfoEntity(
        characterResponse: GetCharacterByIdDbModel
    ): CharacterInfo {
        return CharacterInfo(
            gender = characterResponse.gender,
            id = characterResponse.id,
            image = characterResponse.image,
            name = characterResponse.name,
            origin = characterResponse.origin,
            species = characterResponse.species,
            status = characterResponse.status
        )
    }

    fun mapListDbModelToListEntity(dbModelList: List<GetCharacterByIdDbModel>) : List<CharacterInfo> {
        return dbModelList.map {
            mapCharacterInfoDbModelToCharacterInfoEntity(it)
        }
    }

    fun mapCharacterInfoEntityToCharacterInfoDbModel(
        characterResponse: CharacterInfo
    ): GetCharacterByIdDbModel {
        return GetCharacterByIdDbModel(
            gender = characterResponse.gender,
            id = characterResponse.id,
            image = characterResponse.image,
            name = characterResponse.name,
            origin = characterResponse.origin,
            species = characterResponse.species,
            status = characterResponse.status
        )
    }
}