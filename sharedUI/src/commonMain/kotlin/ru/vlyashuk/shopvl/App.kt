package ru.vlyashuk.shopvl

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import ru.vlyashuk.shopvl.navigation.BottomNavigationBar
import ru.vlyashuk.shopvl.navigation.BottomNavRoutes
import ru.vlyashuk.shopvl.presentation.ProductsViewModel
import ru.vlyashuk.shopvl.screens.CartScreen
import ru.vlyashuk.shopvl.screens.CatalogScreen
import ru.vlyashuk.shopvl.screens.FavoritesScreen
import ru.vlyashuk.shopvl.screens.HomeScreen
import ru.vlyashuk.shopvl.screens.ProfileScreen
import ru.vlyashuk.shopvl.theme.AppTheme

@Composable
fun App(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}
) = AppTheme(onThemeChanged) {
    val navController = rememberNavController()

    val productsViewModel: ProductsViewModel = koinViewModel()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavRoutes.HOME
        ) {
            composable(BottomNavRoutes.HOME) {
                HomeScreen(
                    paddingValues = paddingValues,
                    productsViewModel = productsViewModel)
            }
            composable(BottomNavRoutes.CATALOG) { CatalogScreen() }
            composable(BottomNavRoutes.CART) { CartScreen() }
            composable(BottomNavRoutes.FAVORITES) { FavoritesScreen() }
            composable(BottomNavRoutes.PROFILE) { ProfileScreen() }
        }
    }
}
