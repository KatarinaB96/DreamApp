package com.dream.utils

sealed class Screen(val route: String) {
    object Main : Screen("main")
    object Home : Screen("Home")
    object PageCurl : Screen("Story")
    object Story : Screen("Story")
}