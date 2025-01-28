package com.example.hw3_compose.data.paging.character

import com.example.hw3_compose.model.CharacterModel

sealed class CharacterDetailState {
    object Loading : CharacterDetailState()
    data class Success(val character: CharacterModel) : CharacterDetailState()
    data class Error(val message: String) : CharacterDetailState()
}