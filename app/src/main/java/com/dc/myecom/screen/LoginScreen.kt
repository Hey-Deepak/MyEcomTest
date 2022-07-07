package com.dc.myecom.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dc.myecom.R
import com.dc.myecom.data.User
import com.dc.myecom.viewmodel.LoginViewModel
import kotlin.math.log

@Composable
fun LoginScreen() {
    val context = LocalContext.current
    val loginViewModel = LoginViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Cart
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_shopping_cart_24),
            contentDescription = "Cart",
            Modifier.size(200.dp),
            colorFilter = ColorFilter.tint(Color.Blue)
        )

        Spacer(modifier = Modifier.size(20.dp))

        // Mobile Number
        OutlinedTextField(
            value = loginViewModel.mobileNumber.value,
            onValueChange = {
                loginViewModel.mobileNumber.value = it
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

        // Password
        OutlinedTextField(
            value = loginViewModel.password.value,
            onValueChange = {
                loginViewModel.password.value = it
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

        Spacer(modifier = Modifier.size(10.dp))

        // Forgot Password
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "Forgot Password", color = Color.Magenta)
        }

        Spacer(modifier = Modifier.size(20.dp))

        // Sign-In Button
        Button(
            onClick = {



                Toast.makeText(context, "User Signed In", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier
                .width(250.dp)
                .padding(20.dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Text(text = "SIGN UP",
                fontSize = 24.sp)
        }

        // Sign Up
        Row {
            Text(text = "Not a member yet?  ")
            Text(text = "Sign Up", color = Color.Magenta)

        }

    }
}