package com.example.simplemorty.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplemorty.data.network.model.GetCharacterByIdResponse
import com.example.simplemorty.repository.SharedRepository
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val repository = SharedRepository()

    private val _characterByIdLD = MutableLiveData<GetCharacterByIdResponse?>()
    val characterByIdLD: LiveData<GetCharacterByIdResponse?>
        get() = _characterByIdLD

    fun refreshCharacter(characterId: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)

            _characterByIdLD.postValue(response)
        }
    }
}