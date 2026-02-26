package ru.vlyashuk.shopvl.utils

import com.russhwolf.settings.Settings

expect class SettingsFactory() {
    fun create(): Settings
}