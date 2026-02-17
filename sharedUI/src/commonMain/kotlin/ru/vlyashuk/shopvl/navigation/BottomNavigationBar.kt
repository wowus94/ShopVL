package ru.vlyashuk.shopvl.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.stringResource
import shopvl.sharedui.generated.resources.Res
import shopvl.sharedui.generated.resources.cart
import shopvl.sharedui.generated.resources.catalog
import shopvl.sharedui.generated.resources.favorites
import shopvl.sharedui.generated.resources.home
import shopvl.sharedui.generated.resources.profile

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavItems = listOf(
        BottomNavItem(BottomNavRoutes.HOME, Icons.Default.Home, Res.string.home),
        BottomNavItem(BottomNavRoutes.CATALOG, Icons.Default.Category, Res.string.catalog),
        BottomNavItem(BottomNavRoutes.CART, Icons.Default.ShoppingCart, Res.string.cart),
        BottomNavItem(BottomNavRoutes.FAVORITES, Icons.Default.Favorite, Res.string.favorites),
        BottomNavItem(BottomNavRoutes.PROFILE, Icons.Default.AccountCircle, Res.string.profile),
    )

    NavigationBar {
        bottomNavItems.forEach { item ->

            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = stringResource(item.titleRes)
                    )
                },
                label = {
                    Text(stringResource(item.titleRes))
                }
            )
        }
    }
}