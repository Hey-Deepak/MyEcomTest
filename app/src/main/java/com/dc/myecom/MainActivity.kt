package com.dc.myecom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.dc.myecom.screen.LoginScreen
import com.dc.myecom.screen.MainScreen
import com.dc.myecom.screen.SignupScreen
import com.dc.myecom.ui.theme.MyEcomTheme
import com.dc.myecom.viewmodel.LoginViewModel
import com.dc.myecom.viewmodel.ProfileViewModel
import com.dc.myecom.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyEcomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Log.d("TAG", "onCreate: ")
                    val profileViewModel: ProfileViewModel by viewModels()
                    val userViewModel: UserViewModel by viewModels()
                    val loginViewModel: LoginViewModel by viewModels()
                    MainScreen(profileViewModel, userViewModel, loginViewModel)

                }
            }
        }
    }
}