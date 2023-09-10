package com.example.readerapp.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.R
import com.example.readerapp.navigation.ReaderScreens
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
            Surface(
                modifier = Modifier
                    .padding(15.dp)
                    .size(330.dp),
                color = colorResource(id = R.color.green)
            ) {
                Column(
                    modifier = Modifier.border(
                        5.dp,
                        brush = Brush.linearGradient(
                            listOf(
                                colorResource(id = R.color.logo_cyan),
                                colorResource(id = R.color.logo_green),
                                colorResource(
                                    id = R.color.smoke
                                )
                            )
                        ),
                        shape = CircleShape
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Just read :)",
                        color = colorResource(id = R.color.smoke),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,

                        )
                    Image(
                        painter = painterResource(
                            id = R.drawable.splash_book
                        ),
                        contentDescription = "Sun icon",

                        )


                }


            }

        }
    }
}