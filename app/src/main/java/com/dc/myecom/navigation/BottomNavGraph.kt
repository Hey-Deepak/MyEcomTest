package com.dc.myecom

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dc.myecom.navigation.AuthScreen
import com.dc.myecom.navigation.BottomBarScreen
import com.dc.myecom.screen.*
import com.dc.myecom.viewmodel.ProfileViewModel
import com.dc.myecom.viewmodel.UserViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavGraph(
    navController: NavHostController,
    profileViewModel: ProfileViewModel,
    userViewModel: UserViewModel
) {


    NavHost(navController = navController, startDestination = AuthScreen.Login.route){


        composable(route = BottomBarScreen.Home.route){
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Category.route){
            CategoryScreen(navController)
        }
        composable(route = BottomBarScreen.Orders.route){
            OrderScreen(navController)
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen(navController)
        }
        composable(route = AuthScreen.Login.route){
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Signup.route){
            SignupScreen(profileViewModel = profileViewModel, userViewModel = userViewModel, navController)
        }
    }
}