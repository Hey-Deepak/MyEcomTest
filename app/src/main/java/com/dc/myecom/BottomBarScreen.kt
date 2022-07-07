package com.dc.myecom


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_baseline_home_24
    )
    object Category : BottomBarScreen(
        route = "category",
        title = "Category",
        icon = R.drawable.ic_baseline_category_24
    )
    object Orders : BottomBarScreen(
        route = "orders",
        title = "Orders",
        icon = R.drawable.ic_baseline_order_bag_24
    )
    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.ic_baseline_profile_circle_24
    )
}
