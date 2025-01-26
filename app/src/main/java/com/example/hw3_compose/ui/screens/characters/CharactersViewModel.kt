package com.example.hw3_compose.ui.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.repository.CharactersRepository
import com.example.hw3_compose.model.CharacterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersViewModel(private val charactersRepository: CharactersRepository) : ViewModel() {
    private val _characters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val characters: StateFlow<List<CharacterModel>> = _characters.asStateFlow()

    fun fetchAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _characters.value = charactersRepository.getAllCharacter()
            } catch (e: Exception) {
                _characters.value = emptyList()
            }
        }
    }
}