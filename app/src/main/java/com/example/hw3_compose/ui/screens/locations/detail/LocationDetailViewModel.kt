package com.example.hw3_compose.ui.screens.locations.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.paging.location.LocationDetailState
import com.example.hw3_compose.data.repository.LocationsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationDetailViewModel(private val repository: LocationsRepository) : ViewModel() {

    private val _state = MutableStateFlow<LocationDetailState>(LocationDetailState.Loading)
    val state: StateFlow<LocationDetailState> = _state

    fun getLocationById(locationId: Int) {
        viewModelScope.launch {
            try {
                _state.value = LocationDetailState.Loading

                repository.getLocationById(locationId).collect { location ->
                    if (location != null) {
                        _state.value = LocationDetailState.Success(location)
                    } else {
                        _state.value = LocationDetailState.Error("Location not found")
                    }
                }
            } catch (e: Exception) {
                _state.value = LocationDetailState.Error(e.message ?: "Unknown error")
            }
        }
    }
}