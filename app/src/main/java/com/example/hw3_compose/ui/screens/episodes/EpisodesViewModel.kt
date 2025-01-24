package com.example.hw3_compose.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.api.EpisodeApiService
import com.example.hw3_compose.model.EpisodeModel
import com.example.hw3_compose.model.toEpisodeModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodesViewModel(private val apiService: EpisodeApiService) : ViewModel() {
    private val _episodes = MutableStateFlow<List<EpisodeModel>>(emptyList())
    val episodes: StateFlow<List<EpisodeModel>> = _episodes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchAllEpisodes() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = apiService.getAllEpisodes()
                _episodes.value = response.episodesResponse.map { it.toEpisodeModel() }
            } catch (e: Exception) {
            } finally {
                _isLoading.value = false
            }
        }
    }
}