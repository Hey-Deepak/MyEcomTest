package com.dc.myecom.screen

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dc.myecom.R
import com.dc.myecom.repository.UserRepository
import com.dc.myecom.screen.components.TopBar
import com.dc.myecom.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
) {
    val context = LocalContext.current
    val profileViewModel = ProfileViewModel()
    Column(modifier = Modifier) {
        TopBar(title = "Edit Profile", buttonIcon = painterResource(id = R.drawable.ic_baseline_arrow_back_24)) {
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            // Profile Image
            AsyncImage(model = "https://play-lh.googleusercontent.com/I-Yd5tJnxw7Ks8FUhUiFr8I4kohd9phv5sRFHG_-nSX9AAD6Rcy570NBZVFJBKpepmc=w240-h480-rw",
                contentDescription = "",
                modifier = Modifier.size(200.dp))

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

            Spacer(modifier = Modifier.size(32.dp))

            // Save

            Button(
                onClick = {

                    Toast.makeText(context, "Profile Saved", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .width(250.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            ) {
                Text(text = "SAVE",
                    fontSize = 24.sp)
            }



            // Cancel

            Button(
                onClick = {

                    Toast.makeText(context, "Canceled", Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .width(250.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
            ,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)) {
                Text(text = "Cancel",
                    fontSize = 20.sp)
            }
        }
    }

}