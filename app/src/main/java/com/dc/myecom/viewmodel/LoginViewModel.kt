package com.dc.myecom.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    val mobileNumber = mutableStateOf("")
    val password = mutableStateOf("")
}