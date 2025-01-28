package com.example.hw3_compose.data.serviceLocator

import com.example.hw3_compose.ui.screens.characters.CharactersViewModel
import com.example.hw3_compose.ui.screens.characters.detail.CharacterDetailViewModel
import com.example.hw3_compose.ui.screens.episodes.EpisodesViewModel
import com.example.hw3_compose.ui.screens.episodes.detail.EpisodeDetailViewModel
import com.example.hw3_compose.ui.screens.fav.FavoriteCharactersViewModel
import com.example.hw3_compose.ui.screens.locations.LocationsViewModel
import com.example.hw3_compose.ui.screens.locations.detail.LocationDetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { FavoriteCharactersViewModel(get()) }
    viewModel { CharacterDetailViewModel(get()) }
    viewModel { EpisodeDetailViewModel(get()) }
    viewModel { LocationDetailViewModel(get()) }
}