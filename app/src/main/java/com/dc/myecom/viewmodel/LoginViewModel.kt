package com.dc.myecom.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dc.myecom.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    val mobileNumber = mutableStateOf("")
    val password = mutableStateOf("")
    val name = mutableStateOf("")
    val email = mutableStateOf("")
    val isProfileExit = mutableStateOf(false)

    fun isProfileExit(mobileNumber: String, password: String, onProfileExit:()-> Unit, onProfileDoesNotExit:()->Unit){
        viewModelScope.launch {
            var result = false
            isProfileExit.value = result

            withContext(Dispatchers.IO) {
                val allUserData = userRepository.readAllData()
                Log.d("TAG", "isProfileExit: $allUserData")

                allUserData.forEach {
                    Log.d("TAG", "isProfileExit: ${it}")
                    if (it.mobileNumber == mobileNumber && it.password == password){
                        result = true
                        email.value = it.emailId
                        name.value = it.name
                    }
                }
                withContext(Dispatchers.Main){
                    if (result) onProfileExit()
                    else onProfileDoesNotExit()
                }
            }

        }

    }
}