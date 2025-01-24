package com.example.hw3_compose.data.api

import com.example.hw3_compose.data.dto.EpisodesResultResponse
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun getAllEpisodes(): EpisodesResultResponse
}