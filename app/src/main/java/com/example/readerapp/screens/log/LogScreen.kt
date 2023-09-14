package com.example.readerapp.screens.log


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.utils.Logo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogScreen(navController: NavHostController = rememberNavController()) {
    Surface(modifier = Modifier.fillMaxSize()){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Logo(size = 260.dp)
            OutlinedTextField(value = "Name", onValueChange ={} )
            OutlinedTextField(value = "Password", onValueChange ={} )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Log in")
            }
        }
    }
}