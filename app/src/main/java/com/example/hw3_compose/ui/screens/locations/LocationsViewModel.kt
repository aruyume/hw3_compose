package com.example.hw3_compose.ui.screens.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.hw3_compose.data.repository.LocationsRepository

class LocationsViewModel(private val locationsRepository: LocationsRepository) : ViewModel() {
    val locations = locationsRepository.getLocationsPager()
        .flow
        .cachedIn(viewModelScope)
}