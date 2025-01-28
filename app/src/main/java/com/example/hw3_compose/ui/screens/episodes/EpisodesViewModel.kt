package com.example.hw3_compose.ui.screens.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hw3_compose.data.repository.EpisodesRepository

class EpisodesViewModel(private val episodesRepository: EpisodesRepository) : ViewModel() {
    val episodes = episodesRepository.getEpisodesPager()
        .flow
        .cachedIn(viewModelScope)
}