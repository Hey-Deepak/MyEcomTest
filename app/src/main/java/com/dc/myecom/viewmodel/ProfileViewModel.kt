package com.dc.myecom.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dc.myecom.model.profile.Profile

class ProfileViewModel: ViewModel() {
    fun signup(profile:Profile) {
        userNameState.value = profile.name
        userEmailidState.value = profile.emailId
        userMobileNumberState.value = profile.mobileNumber
        userReferralCodeState.value = profile.referralCode
        userPasswordState.value = profile.password
    }

    val userNameState = mutableStateOf("")
    val userEmailidState = mutableStateOf("")
    val userMobileNumberState = mutableStateOf("")
    val userReferralCodeState = mutableStateOf("")
    val userPasswordState = mutableStateOf("")
 }