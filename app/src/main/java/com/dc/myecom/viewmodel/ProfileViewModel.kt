package com.dc.myecom.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.room.Insert
import com.dc.myecom.model.profile.Profile
import com.dc.myecom.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor (
    val userRepository: UserRepository
): ViewModel() {
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