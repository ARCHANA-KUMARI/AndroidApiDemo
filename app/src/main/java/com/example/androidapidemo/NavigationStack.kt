package com.example.androidapidemo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun NavigationStack(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Main,
        modifier = modifier,
    ) {
        composable<Main> {
            MainScreen(
                onNext = { text ->
                    navController.navigate(Detail(text)) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Detail> { entry ->
            DetailScreen(text = entry.toRoute<Detail>().text)
        }
    }
}

