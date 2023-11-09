package com.example.simplemorty.data.network.model

data class GetCharactersPageResponse(
    val info: Info,
    val results: List<GetCharacterByIdResponse>
)