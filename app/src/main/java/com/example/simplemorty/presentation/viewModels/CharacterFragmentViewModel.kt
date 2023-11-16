package com.example.simplemorty.presentation.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.data.room.RepositoryImpl
import com.example.simplemorty.domain.AddCharacterUseCase
import com.example.simplemorty.repository.SharedRepository
import kotlinx.coroutines.launch

class CharacterFragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = SharedRepository()
    private val dbRepository = RepositoryImpl(application)

    private val addCharacterUseCase = AddCharacterUseCase(dbRepository)

    private val _characterByIdLD = MutableLiveData<GetCharacterByIdResponse?>()
    val characterByIdLD: LiveData<GetCharacterByIdResponse?>
        get() = _characterByIdLD

    fun refreshCharacter(characterId: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)
            _characterByIdLD.postValue(response)
        }
    }

    fun addCharacter(response: GetCharacterByIdResponse) {
        viewModelScope.launch {
            addCharacterUseCase.addCharacter(response)
        }
    }
}