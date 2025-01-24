package com.example.hw3_compose.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hw3_compose.ui.screens.characters.CharactersScreen
import com.example.hw3_compose.ui.screens.characters.CharactersViewModel
import com.example.hw3_compose.ui.screens.locations.LocationsScreen
import com.example.hw3_compose.ui.screens.episodes.EpisodesScreen
import com.example.hw3_compose.ui.screens.characters.detail.CharacterDetailScreen
import com.example.hw3_compose.ui.screens.episodes.EpisodesViewModel
import com.example.hw3_compose.ui.screens.episodes.detail.EpisodeDetailScreen
import com.example.hw3_compose.ui.screens.locations.LocationsViewModel
import com.example.hw3_compose.ui.screens.locations.detail.LocationDetailScreen
import org.koin.compose.viewmodel.koinViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    val charactersViewModel: CharactersViewModel = koinViewModel()
    val locationsViewModel: LocationsViewModel = koinViewModel()
    val episodesViewModel: EpisodesViewModel = koinViewModel()

    NavHost(navController = navController, startDestination = "characters") {
        composable("characters") {
            CharactersScreen(
                onNavigateToDetail = { characterId ->
                    navController.navigate("character_detail/$characterId")
                },
                paddingValues = paddingValues,
                charactersViewModel = charactersViewModel
            )
        }

        composable("locations") {
            LocationsScreen(
                onNavigateToDetail = { locationId ->
                    navController.navigate("location_detail/$locationId")
                },
                paddingValues = paddingValues,
                locationsViewModel = locationsViewModel
            )
        }

        composable("episodes") {
            EpisodesScreen(
                onNavigateToDetail = { episodesId ->
                    navController.navigate("episode_detail/$episodesId")
                },
                paddingValues = paddingValues,
                episodesViewModel = episodesViewModel
            )
        }

        composable("character_detail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toInt() ?: 0
            val character =
                charactersViewModel.characters.value.firstOrNull { it.id == characterId }
            if (character != null) {
                CharacterDetailScreen(
                    character = character,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        composable("location_detail/{locationId}") { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")?.toInt() ?: 0
            val location = locationsViewModel.locations.value.firstOrNull { it.id == locationId }
            if (location != null) {
                LocationDetailScreen(
                    location = location,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }

        composable("episode_detail/{episodeId}") { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toInt() ?: 0
            val episode = episodesViewModel.episodes.value.firstOrNull { it.id == episodeId }
            if (episode != null) {
                EpisodeDetailScreen(
                    episode = episode,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}