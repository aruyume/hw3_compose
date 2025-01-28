package com.example.hw3_compose.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw3_compose.data.db.daos.FavoriteCharacterDao
import com.example.hw3_compose.model.CharacterModel

@Database(entities = [CharacterModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCharacterDao(): FavoriteCharacterDao
}