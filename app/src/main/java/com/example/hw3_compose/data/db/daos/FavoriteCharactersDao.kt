package com.example.hw3_compose.data.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hw3_compose.model.CharacterModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDao {
    @Insert
    suspend fun addFavoriteCharacter(character: CharacterModel)

    @Delete
    suspend fun removeFavoriteCharacter(character: CharacterModel)

    @Query("SELECT * FROM favorite_characters")
    fun getAllFavoriteCharacters(): Flow<List<CharacterModel>>

    @Query("SELECT * FROM favorite_characters WHERE id = :id LIMIT 1")
    suspend fun getFavoriteCharacterById(id: Int): CharacterModel?
}