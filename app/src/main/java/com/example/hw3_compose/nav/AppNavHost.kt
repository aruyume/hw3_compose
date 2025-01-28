package com.example.hw3_compose.nav

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
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
import com.example.hw3_compose.ui.screens.episodes.detail.EpisodeDetailViewModel
import com.example.hw3_compose.ui.screens.fav.FavoriteCharactersViewModel
import com.example.hw3_compose.ui.screens.fav.FavoritesScreen
import com.example.hw3_compose.ui.screens.locations.LocationsViewModel
import com.example.hw3_compose.ui.screens.locations.detail.LocationDetailScreen
import com.example.hw3_compose.ui.screens.locations.detail.LocationDetailViewModel
import org.koin.compose.viewmodel.koinViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    val charactersViewModel: CharactersViewModel = koinViewModel()
    val locationsViewModel: LocationsViewModel = koinViewModel()
    val episodesViewModel: EpisodesViewModel = koinViewModel()
    val favoriteCharactersViewModel: FavoriteCharactersViewModel = koinViewModel()
    val episodeDetailViewModel: EpisodeDetailViewModel = koinViewModel()
    val locationDetailViewModel: LocationDetailViewModel = koinViewModel()

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

        composable("favorite_characters") {
            FavoritesScreen(
                onNavigateToDetail = { favId ->
                    navController.navigate("episode_detail/$favId")
                },
                paddingValues = paddingValues,
                favoritesViewModel = favoriteCharactersViewModel
            )
        }

        composable("character_detail/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()

            if (characterId != null) {
                CharacterDetailScreen(
                    characterId = characterId,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() },
                    favoritesViewModel = favoriteCharactersViewModel
                )
            } else {
                Text("Invalid character ID")
            }
        }

        composable("location_detail/{locationId}") { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("locationId")?.toIntOrNull()

            if (locationId != null) {
                LocationDetailScreen(
                    locationId = locationId,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() })
            } else {
                Text("Invalid location ID")
            }
        }

        composable("episode_detail/{episodeId}") { backStackEntry ->
            val episodeId = backStackEntry.arguments?.getString("episodeId")?.toIntOrNull()

            if (episodeId != null) {
                EpisodeDetailScreen(
                    episodeId = episodeId,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                Text("Invalid episode ID")
            }
        }

        composable("favorite_characters/{favId}") {
            FavoritesScreen(
                paddingValues = paddingValues,
                onNavigateToDetail = { favId ->
                    navController.navigate("favorite_characters/$favId")
                },
                favoritesViewModel = koinViewModel()
            )
        }
    }
}