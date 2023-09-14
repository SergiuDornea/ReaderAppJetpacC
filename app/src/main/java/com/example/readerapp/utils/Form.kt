package com.example.readerapp.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.readerapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(text: String , modifier: Modifier = Modifier){
    OutlinedTextField(
        value = text,
        modifier = Modifier.padding(top = 40.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = colorResource(id = R.color.smoke),
            containerColor = colorResource(id = R.color.green),
            cursorColor = colorResource(id = R.color.smoke),
            unfocusedBorderColor = colorResource(id = R.color.pistacio),
            unfocusedSupportingTextColor = colorResource(id = R.color.pistacio),
            focusedBorderColor = colorResource(id = R.color.smoke),

        ),
        singleLine = true,
        onValueChange ={} )
}


@Composable
fun CustomLogInButton(text: String,  btnColor :Color, contentColor : Color){
    Button(
        modifier = Modifier
            .padding(top = 40.dp)
            .size(100.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = btnColor
        ),
        onClick = { /*TODO*/ }) {
        Text(
            text = text,
            color = contentColor
            )
    }


}
