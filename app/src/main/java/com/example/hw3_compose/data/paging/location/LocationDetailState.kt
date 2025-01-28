package com.example.hw3_compose.data.paging.location

import com.example.hw3_compose.model.LocationModel

sealed class LocationDetailState {
    object Loading : LocationDetailState()
    data class Success(val location: LocationModel) : LocationDetailState()
    data class Error(val message: String) : LocationDetailState()
}