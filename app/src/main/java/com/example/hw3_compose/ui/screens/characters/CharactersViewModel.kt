package com.example.hw3_compose.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.api.CharacterApiService
import com.example.hw3_compose.model.CharacterModel
import com.example.hw3_compose.model.toCharacterModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(private val apiService: CharacterApiService) : ViewModel() {
    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchAllCharacters() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = apiService.getAllCharacters()
                _characters.value = response.charactersResponse.map { it.toCharacterModel() }
            } catch (e: Exception) {
            } finally {
                _isLoading.value = false
            }
        }
    }
}
