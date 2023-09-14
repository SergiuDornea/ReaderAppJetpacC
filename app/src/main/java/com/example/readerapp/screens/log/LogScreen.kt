package com.example.readerapp.screens.log


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.R
import com.example.readerapp.utils.CustomLogInButton
import com.example.readerapp.utils.CustomTextField
import com.example.readerapp.utils.Logo


@Preview
@Composable
fun LogScreen(navController: NavHostController = rememberNavController()) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.green)
        ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogInForm()
            }
        }
    }

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun LogInForm() {
    val email = rememberSaveable{mutableStateOf("")}
    val password = rememberSaveable{mutableStateOf("")}
    val passwordVisibility = rememberSaveable{mutableStateOf(false)}
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, password.value){
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    Logo(size = 270.dp)
    CustomTextField("Name", modifier = Modifier.padding(top = 40.dp))
    CustomTextField("Password", modifier = Modifier.padding(top = 20.dp))
    CustomLogInButton(text = "Log in", btnColor = colorResource(id = R.color.pistacio), contentColor = colorResource(id = R.color.dark_green) )


}