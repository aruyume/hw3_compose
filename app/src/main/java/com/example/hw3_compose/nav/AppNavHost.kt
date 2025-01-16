package com.example.hw3_compose.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hw3_compose.model.MockData
import com.example.hw3_compose.ui.screens.CharactersScreen
import com.example.hw3_compose.ui.screens.LocationsScreen
import com.example.hw3_compose.ui.screens.EpisodesScreen
import com.example.hw3_compose.ui.screens.detail.CharacterDetailScreen

@Composable
fun AppNavHost(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = "characters") {
        composable("characters") {
            CharactersScreen(
                onItemClick = { character ->
                    navController.navigate("character_detail/${character.name}")
                },
                paddingValues = paddingValues
            )
        }
        composable("locations") {
            LocationsScreen(paddingValues = paddingValues)
        }
        composable("episodes") {
            EpisodesScreen(paddingValues = paddingValues)
        }
        composable("character_detail/{characterName}") { backStackEntry ->
            val characterName = backStackEntry.arguments?.getString("characterName") ?: ""
            val character = MockData.characters.find { it.name == characterName }
            if (character != null) {
                CharacterDetailScreen(
                    character = character,
                    paddingValues = paddingValues,
                    onBackClick = { navController.popBackStack() }
                )
            }
        }
    }
}