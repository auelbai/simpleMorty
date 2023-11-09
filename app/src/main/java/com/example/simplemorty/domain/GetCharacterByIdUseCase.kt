package com.example.simplemorty.domain

class GetCharacterByIdUseCase(private val repository: CharactersRepository) {

    suspend fun getCharacterById(characterId: Int): CharacterInfo {
        return repository.getCharacterById(characterId)
    }
}