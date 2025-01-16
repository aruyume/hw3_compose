package com.example.hw3_compose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hw3_compose.nav.AppBottomNavigation
import com.example.hw3_compose.nav.AppNavHost
import com.example.hw3_compose.nav.AppTopBar
import com.example.hw3_compose.ui.theme.Hw3_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw3_composeTheme {
                MainApp()
            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    val showBottomBar = currentRoute != null && !currentRoute.contains("detail")

    Scaffold(
        topBar = {
            AppTopBar(navController = navController)
        },
        bottomBar = {
            if (showBottomBar) {
                AppBottomNavigation(navController = navController)
            }
        }
    ) { paddingValues ->
        AppNavHost(
            navController = navController,
            paddingValues = paddingValues
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hw3_composeTheme {
        MainApp()
    }
}