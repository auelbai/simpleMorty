package com.example.simplemorty.data.room

import androidx.room.TypeConverter
import com.example.simplemorty.data.network.model.Origin


class CharacterTypeConverter {
    @TypeConverter
    fun fromOrigin(origin: Origin): String {
        return origin.name
    }

    @TypeConverter
    fun toOrigin(name: String): Origin {
        return Origin(name, name)
    }
}