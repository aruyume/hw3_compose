package com.example.hw3_compose.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw3_compose.data.api.LocationApiService
import com.example.hw3_compose.model.LocationModel
import com.example.hw3_compose.model.toLocationModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationsViewModel(private val apiService: LocationApiService) : ViewModel() {
    private val _locations = MutableStateFlow<List<LocationModel>>(emptyList())
    val locations: StateFlow<List<LocationModel>> = _locations

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchAllLocations() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = apiService.getAllLocations()
                _locations.value = response.locationsResponse.map { it.toLocationModel() }
            } catch (e: Exception) {
            } finally {
                _isLoading.value = false
            }
        }
    }
}