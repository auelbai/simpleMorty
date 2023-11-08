package com.example.simplemorty.network

import com.example.simplemorty.model.GetCharacterByIdResponse
import com.example.simplemorty.model.GetCharactersPageResponse
import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): SimpleResponse<GetCharacterByIdResponse> {
        return safeApiCall { rickAndMortyService.getCharacterById(characterId) }
    }

    suspend fun getCharacterList(pageIndex: Int): SimpleResponse<GetCharactersPageResponse> {
        return safeApiCall { rickAndMortyService.getAllCharacters(pageIndex) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }

}
