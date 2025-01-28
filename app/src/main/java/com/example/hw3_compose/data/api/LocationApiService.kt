package com.example.hw3_compose.data.api

import com.example.hw3_compose.data.dto.LocationsResultResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun getAllLocations(
        @Query("page") page: Int
    ): LocationsResultResponse
}