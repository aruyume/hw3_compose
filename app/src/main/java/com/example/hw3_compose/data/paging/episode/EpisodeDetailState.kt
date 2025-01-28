package com.example.hw3_compose.data.paging.episode

import com.example.hw3_compose.model.EpisodeModel

sealed class EpisodeDetailState {
    object Loading : EpisodeDetailState()
    data class Success(val episode: EpisodeModel) : EpisodeDetailState()
    data class Error(val message: String) : EpisodeDetailState()
}