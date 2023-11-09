package com.example.simplemorty.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("SELECT * FROM simple_morty")
    fun getAllCharacters(): LiveData<List<GetCharacterByIdDbModel>>

    @Query("SELECT * FROM simple_morty WHERE id = :characterId LIMIT 1")
    suspend fun getCharacterById(characterId: Int): GetCharacterByIdDbModel

    @Insert
    suspend fun addCharacter(character: GetCharacterByIdDbModel)

    @Delete
    suspend fun deleteCharacter(character: GetCharacterByIdDbModel)
}