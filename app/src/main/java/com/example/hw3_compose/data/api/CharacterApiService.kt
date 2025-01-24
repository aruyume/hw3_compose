package com.example.hw3_compose.data.api

import com.example.hw3_compose.data.dto.CharactersResultResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    suspend fun getAllCharacters() : CharactersResultResponse
}