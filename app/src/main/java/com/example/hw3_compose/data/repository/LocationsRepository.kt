package com.example.hw3_compose.data.repository

import com.example.hw3_compose.data.api.LocationApiService
import com.example.hw3_compose.model.LocationModel
import com.example.hw3_compose.model.toLocationModel

class LocationsRepository(private val apiService: LocationApiService) {

    suspend fun getAllCharacter(): List<LocationModel> {
        val response = apiService.getAllLocations()
        return response.locationsResponse.map { it.toLocationModel() }
    }
}