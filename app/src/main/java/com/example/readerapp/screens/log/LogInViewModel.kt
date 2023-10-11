package com.example.readerapp.screens.log

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImagePainter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LogInViewModel : ViewModel(){
//    val loadingState = MutableStateFlow(LoadingState.IDLE)
    private val auth: FirebaseAuth = Firebase.auth

    // use it internally
    private val _loading = MutableLiveData(false)
    // use it externally
    val loading: LiveData<Boolean> = _loading


    // run it in a different scope
    fun signUserWithEmailAndPassword(email: String, password: String)= viewModelScope.launch{
        try {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {task->
                    if (task.isSuccessful){
                        TODO("take them home")
                    }else{
                        Log.d("FB", "signUserWithEmailAndPassword: ${task.result} ")
                    }
                    
                }
        }catch (ex : Exception){
            Log.d("FB", "signUserWithEmailAndPassword: ${ex.message}")
        }
    }


    fun createUserWithEmailAndPassword(){}

}