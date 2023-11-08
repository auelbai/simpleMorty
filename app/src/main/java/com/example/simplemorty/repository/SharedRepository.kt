package com.example.simplemorty.repository

import com.example.simplemorty.model.GetCharacterByIdResponse
import com.example.simplemorty.model.GetCharactersPageResponse
import com.example.simplemorty.network.NetworkLayer

class SharedRepository {

    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.failed) {
            return null
        }

        if (!request.success) {
            return null
        }

        return request.body
    }

    suspend fun getCharacterPage(pageIndex: Int): GetCharactersPageResponse? {
        val request = NetworkLayer.apiClient.getCharacterList(pageIndex)

        if (request.failed || !request.success) {
            return null
        }
        return request.body
    }

}
