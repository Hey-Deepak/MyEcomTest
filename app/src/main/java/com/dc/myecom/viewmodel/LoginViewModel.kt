package com.dc.myecom.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dc.myecom.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    val mobileNumber = mutableStateOf("")
    val password = mutableStateOf("")
    val isProfileExit = mutableStateOf(false)

    fun isProfileExit(mobileNumber: String, password: String){
        viewModelScope.launch {
            var result = false
            isProfileExit.value = result

            val allUserData = async { userRepository.readAllData().value }.await()
            Log.d("TAG", "isProfileExit: $allUserData")

            allUserData?.forEach {
                Log.d("TAG", "isProfileExit: ${it}")
                if (it.mobileNumber == mobileNumber && it.password == password){
                    result = true
                    isProfileExit.value = result
                }
            }
        }

    }
}