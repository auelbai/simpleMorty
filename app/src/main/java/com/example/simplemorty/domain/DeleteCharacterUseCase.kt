package com.example.simplemorty.domain

class DeleteCharacterUseCase(private val repository: CharactersRepository) {

    suspend fun deleteCharacter(characterInfo: CharacterInfo) {
        repository.deleteCharacter(characterInfo)
    }
}