package com.example.hw3_compose.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.repository.EpisodesRepository
import com.example.hw3_compose.model.EpisodeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(private val episodesRepository: EpisodesRepository) : ViewModel() {
    private val _episodes = MutableStateFlow<List<EpisodeModel>>(emptyList())
    val episodes: StateFlow<List<EpisodeModel>> = _episodes.asStateFlow()

    fun fetchAllEpisodes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _episodes.value = episodesRepository.getAllEpisodes()
            } catch (e: Exception) {
                _episodes.value = emptyList()
            }
        }
    }
}