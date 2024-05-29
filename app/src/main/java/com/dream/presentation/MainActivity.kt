package com.dream.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dream.ui.theme.DreamTheme
import com.dream.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DreamTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Main.route) {
                        composable(Screen.Main.route) {
                            MainScreen(navController)
                        }
                        composable(Screen.Home.route) { HomeScreen(navController) }
                        composable(Screen.Story.route) { StoryScreen() }


                        composable(Screen.PageCurl.route) { PageCurlScreen(navController) }
                    }
                }
            }
        }
    }
}


