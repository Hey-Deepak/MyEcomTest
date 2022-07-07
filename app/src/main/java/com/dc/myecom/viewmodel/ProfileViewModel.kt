package com.dc.myecom.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dc.myecom.model.profile.Profile

class ProfileViewModel: ViewModel() {
    fun clear() {
        userNameState.value = ""
        userEmailidState.value = ""
        userMobileNumberState.value = ""
        userReferralCodeState.value = ""
        userPasswordState.value = ""
    }



    val userNameState = mutableStateOf("")
    val userEmailidState = mutableStateOf("")
    val userMobileNumberState = mutableStateOf("")
    val userReferralCodeState = mutableStateOf("")
    val userPasswordState = mutableStateOf("")
 }