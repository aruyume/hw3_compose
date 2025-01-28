package com.example.hw3_compose.data.api

import com.example.hw3_compose.data.dto.CharactersResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharactersResultResponse
}