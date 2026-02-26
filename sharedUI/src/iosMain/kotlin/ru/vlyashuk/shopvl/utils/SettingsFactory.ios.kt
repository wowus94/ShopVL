package ru.vlyashuk.shopvl.utils

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import platform.Foundation.NSUserDefaults

actual class SettingsFactory actual constructor() {

    actual fun create(): Settings {
        val defaults = NSUserDefaults.standardUserDefaults
        return NSUserDefaultsSettings(defaults)
    }
}