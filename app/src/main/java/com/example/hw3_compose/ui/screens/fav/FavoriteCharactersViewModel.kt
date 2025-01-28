package com.example.hw3_compose.ui.screens.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.repository.FavoriteCharactersRepository
import com.example.hw3_compose.model.CharacterModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FavoriteCharactersViewModel(private val repository: FavoriteCharactersRepository) :
    ViewModel() {
    val favoriteCharacters: Flow<List<CharacterModel>> = repository.favoriteCharacters

    fun addFavoriteCharacter(character: CharacterModel) {
        viewModelScope.launch {
            repository.addFavoriteCharacter(character)
        }
    }

    fun removeFavoriteCharacter(character: CharacterModel) {
        viewModelScope.launch {
            repository.removeFavoriteCharacter(character)
        }
    }

    fun isFavorite(id: Int, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            callback(repository.isFavorite(id))
        }
    }
}