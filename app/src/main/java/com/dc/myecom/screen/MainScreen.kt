package com.dc.myecom.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dc.myecom.navigation.BottomBarScreen
import com.dc.myecom.NavGraph
import com.dc.myecom.viewmodel.LoginViewModel
import com.dc.myecom.viewmodel.ProfileViewModel
import com.dc.myecom.viewmodel.UserViewModel

@Composable
fun MainScreen(profileViewModel: ProfileViewModel, userViewModel: UserViewModel, loginViewModel: LoginViewModel) {
    val navController = rememberNavController()

    NavGraph(navController = navController, profileViewModel, userViewModel, loginViewModel)

}

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Category,
        BottomBarScreen.Orders,
        BottomBarScreen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation() {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = "Home")
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route){
                 popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}