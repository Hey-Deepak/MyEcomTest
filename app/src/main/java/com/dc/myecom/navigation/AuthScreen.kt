package com.dc.myecom.navigation

sealed class AuthScreen(val route: String){
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")
}
