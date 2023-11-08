package com.example.simplemorty.model

data class GetCharactersPageResponse(
    val info: Info,
    val results: List<GetCharacterByIdResponse>
)