package com.example.simplemorty.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.simplemorty.presentation.CharactersPagingSource
import com.example.simplemorty.repository.SharedRepository

class AllCharactersViewModel: ViewModel() {

    private val repository = SharedRepository()

    val pagerLD = Pager(
        PagingConfig(20)
    ) {
        CharactersPagingSource(repository)
    }.liveData
        .cachedIn(viewModelScope)
}