package com.example.simplemorty.data.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [GetCharacterByIdDbModel::class], version = 1, exportSchema = false)
@TypeConverters(CharacterTypeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object{
        private val LOCK = Any()
        private val DB_NAME = "simple_morty_db"
        private var INSTANCE: AppDatabase? = null

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java, DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}