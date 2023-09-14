package com.example.readerapp.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.R
import com.example.readerapp.navigation.ReaderScreens
import com.example.readerapp.utils.Logo
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavHostController = rememberNavController()) {

    LaunchedEffect(key1 = true, block ={
        delay(1000L)
        navController.navigate(route = ReaderScreens.LogScreen.name)
    } )


    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.green))
        ) {
            Logo(330.dp)

        }
    }
}