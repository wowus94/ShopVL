package ru.vlyashuk.shopvl.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource

data class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val titleRes: StringResource
)