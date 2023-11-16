package com.example.simplemorty.domain

import com.example.simplemorty.data.network.model.GetCharacterByIdResponse

class AddCharacterUseCase(private val repository: CharactersRepository) {

    suspend fun addCharacter(characterInfo: GetCharacterByIdResponse) {
        repository.addCharacter(characterInfo)
    }
}