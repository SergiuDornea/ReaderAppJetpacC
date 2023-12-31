package com.example.readerapp.screens.log


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.R
import com.example.readerapp.utils.EmailInput
import com.example.readerapp.utils.PasswordInput
import com.example.readerapp.utils.SubmitButton


@Preview
@Composable
fun LogScreen(navController: NavHostController = rememberNavController()) {

    val showLogInForm = rememberSaveable {
        mutableStateOf(true)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.green)
        ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(showLogInForm.value) {
                // show log in form
                UserForm(loading = false, isCreateAccount = false) { email, password ->
                    // TODO Firebase log in 
                }
            }else{
                // show new user form
                UserForm(loading = false, isCreateAccount = true){ email, password ->
                // TODO Firebase new account
                    
                }
            }

            }

        Row(
            modifier = Modifier
                .padding(top = 120.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
            ) {
            val text = if(showLogInForm.value) "Sign up" else "Log in"
            Text(text = "New user?", color = colorResource(id = R.color.pistacio))
            Text(text = text, modifier = Modifier
                .clickable {
                    showLogInForm.value = !showLogInForm.value
                }
                .padding(start = 5.dp),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.smoke))
        }
        }
    }

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun UserForm(
    loading: Boolean = false,
    isCreateAccount: Boolean = false,
    onDone: (String, String) -> Unit = {email, password->}

){
// property's needed
   val email = rememberSaveable { mutableStateOf("") }
   val password = rememberSaveable { mutableStateOf("") }
   val passwordVisibility = rememberSaveable { mutableStateOf(false) }
   val passwordFocusRequest  = FocusRequester.Default
   val keyboardController  = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, password.value){
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    val modifier = Modifier
        .height(400.dp)
        .background(colorResource(id = R.color.green))
        .verticalScroll(rememberScrollState())

    Column(
        modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Just read! :)",
            fontSize = 46.sp,
            color = colorResource(id = R.color.pistacio),
            fontWeight = FontWeight.Bold

            )
        Spacer(modifier = Modifier.padding(top = 35.dp))

        if(isCreateAccount){
            Text(
                text = stringResource(id = R.string.create_account),
                color = colorResource(id = R.color.smoke),
                modifier = Modifier.padding(4.dp)
            )
            
        }
        EmailInput(
            emailState = email,
            enabled = !loading,
            onAction = KeyboardActions{
                passwordFocusRequest.requestFocus()
            }
        )

        PasswordInput(
            modifier = Modifier.focusRequester(passwordFocusRequest),
            passwordState = password,
            labelId = "Password",
            enabled = !loading,
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions {
                if(!valid) return@KeyboardActions
                onDone(email.value.trim(), password.value.trim())
            }
        )

        SubmitButton(
            text = if(isCreateAccount) "Create account" else "Log in",
            loading = loading,
            validInputs = valid,
        ){
            onDone(email.value.trim(), password.value.trim())
            keyboardController?.hide()
        }





    }
}


