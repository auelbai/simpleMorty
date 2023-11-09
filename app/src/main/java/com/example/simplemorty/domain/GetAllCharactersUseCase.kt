package com.example.simplemorty.domain

import androidx.lifecycle.LiveData

class GetAllCharactersUseCase(private val repository: CharactersRepository) {

    fun getAllCharacters(): LiveData<List<CharacterInfo>> {
        return repository.getListCharacters()
    }
}