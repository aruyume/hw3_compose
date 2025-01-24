package com.example.hw3_compose.data.serviceLocator

import com.example.hw3_compose.ui.screens.characters.CharactersViewModel
import com.example.hw3_compose.ui.screens.episodes.EpisodesViewModel
import com.example.hw3_compose.ui.screens.locations.LocationsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
}