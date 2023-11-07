package com.example.simplemorty.repository

import com.example.simplemorty.model.GetCharacterByIdResponse
import com.example.simplemorty.network.NetworkLayer

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }

}
