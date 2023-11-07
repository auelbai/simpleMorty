package com.example.simplemorty.network

import com.example.simplemorty.model.GetCharacterByIdResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character/{character_id}")
    suspend fun getCharacterById(
        @Path("character_id")
        characterId: Int
    ): Response<GetCharacterByIdResponse>
}