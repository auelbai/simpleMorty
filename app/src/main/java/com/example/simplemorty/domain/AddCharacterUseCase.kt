package com.example.simplemorty.domain

class AddCharacterUseCase(private val repository: CharactersRepository) {

    suspend fun addCharacter(characterInfo: CharacterInfo) {
        repository.addCharacter(characterInfo)
    }
}