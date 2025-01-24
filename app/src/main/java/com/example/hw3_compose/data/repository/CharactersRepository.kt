package com.example.hw3_compose.data.repository

import com.example.hw3_compose.data.api.CharacterApiService
import com.example.hw3_compose.model.CharacterModel
import com.example.hw3_compose.model.toCharacterModel

class CharactersRepository(private val apiService: CharacterApiService) {

    suspend fun getAllCharacter(): List<CharacterModel> {
        val response = apiService.getAllCharacters()
        return response.charactersResponse.map { it.toCharacterModel() }
    }
}