package com.example.readerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.screens.details.BookDetailsScreen
import com.example.readerapp.screens.home.HomeScreen
import com.example.readerapp.screens.log.LogScreen
import com.example.readerapp.screens.search.SearchScreen
import com.example.readerapp.screens.splash.SplashScreen
import com.example.readerapp.screens.stats.StatsScreen
import com.example.readerapp.screens.update.UpdateScreen


@Composable
fun ReaderNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name){
        composable(ReaderScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(ReaderScreens.LogScreen.name){
            LogScreen(navController = navController)
        }


        composable(ReaderScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }

        composable(ReaderScreens.SearchScreen.name){
            SearchScreen(navController = navController)
        }

        composable(ReaderScreens.DetailScreen.name){
            BookDetailsScreen(navController = navController)
        }

        composable(ReaderScreens.UpdateScreen.name){
            UpdateScreen(navController = navController)
        }

        composable(ReaderScreens.StatsScreen.name){
            StatsScreen(navController = navController)
        }

    }

}