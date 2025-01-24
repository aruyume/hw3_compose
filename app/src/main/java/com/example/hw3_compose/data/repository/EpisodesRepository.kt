package com.example.hw3_compose.data.repository

import com.example.hw3_compose.data.api.EpisodeApiService
import com.example.hw3_compose.model.EpisodeModel
import com.example.hw3_compose.model.toEpisodeModel

class EpisodesRepository(private val apiService: EpisodeApiService) {

    suspend fun getAllEpisodes(): List<EpisodeModel> {
        val response = apiService.getAllEpisodes()
        return response.episodesResponse.map { it.toEpisodeModel() }
    }
}