package com.example.androidapidemo

sealed class AndroidApiDemoScreen(val route: String) {
    data object Main : AndroidApiDemoScreen("main_screen")
    data object Detail : AndroidApiDemoScreen("detail_screen")
}