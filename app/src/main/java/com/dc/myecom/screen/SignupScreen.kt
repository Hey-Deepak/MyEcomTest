package com.dc.myecom.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dc.myecom.R
import com.dc.myecom.data.User
import com.dc.myecom.model.profile.Profile
import com.dc.myecom.viewmodel.ProfileViewModel
import com.dc.myecom.viewmodel.UserViewModel

@Composable
fun SignupScreen(
    profileViewModel: ProfileViewModel,
    userViewModel: UserViewModel
) {
    val context = LocalContext.current
    val stateScroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(stateScroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = "Cart",
            Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        )

        Spacer(modifier = Modifier.size(20.dp))

        // Name
        OutlinedTextField(
            value = profileViewModel.userNameState.value,
            onValueChange = {
                profileViewModel.userNameState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Text(text = "Name")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        // Email
        OutlinedTextField(
            value = profileViewModel.userEmailidState.value,
            onValueChange = {
                profileViewModel.userEmailidState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Text(text = "Email Id")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_email_24),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        // Mobile Number
        OutlinedTextField(
            value = profileViewModel.userMobileNumberState.value,
            onValueChange = {
                profileViewModel.userMobileNumberState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Text(text = "Mobile Number")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_call_24),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        // Referral Code
        OutlinedTextField(
            value = profileViewModel.userReferralCodeState.value,
            onValueChange = {
                profileViewModel.userReferralCodeState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Text(text = "Referral Code (Optional)")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_home_24),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        // Password
        OutlinedTextField(
            value = profileViewModel.userPasswordState.value,
            onValueChange = {
                profileViewModel.userPasswordState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            textStyle = TextStyle(fontSize = 20.sp),
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = ""
                )
            }
        )

        Spacer(modifier = Modifier.size(20.dp))

        // Signup Button
        Button(
            onClick = {

                      userViewModel.addUser(user = User(
                          profileViewModel.userNameState.value,
                          profileViewModel.userEmailidState.value,
                          profileViewModel.userMobileNumberState.value,
                          profileViewModel.userReferralCodeState.value,
                          profileViewModel.userPasswordState.value
                      ))
                      profileViewModel.clear()
                Toast.makeText(context, "Profile Created", Toast.LENGTH_LONG).show()
                       },
            modifier = Modifier
                .width(250.dp)
                .padding(20.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Text(text = "SIGN UP",
            fontSize = 24.sp)
        }

        // Sign IN
        Row {
        Text(text = "Already Have an Account?  ")
            Text(text = "Sign In", color = Color.Magenta)
            
        }

    }
}