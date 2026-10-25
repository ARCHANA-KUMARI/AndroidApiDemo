package com.example.androidapidemo

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationStack() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AndroidApiDemoScreen.Main.route) {
        composable(route = AndroidApiDemoScreen.Main.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = AndroidApiDemoScreen.Detail.route + "?text={text}",
            arguments = listOf(
                navArgument("text") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            DetailScreen(text = it.arguments?.getString("text"))
        }
    }
}

