package ru.vlyashuk.shopvl.utils

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.mp.KoinPlatform.getKoin

actual class SettingsFactory actual constructor() {

    private val context: Context
        get() = getKoin().get()

    actual fun create(): Settings {
        val prefs = context.getSharedPreferences(
            "ru.vlyashuk.shopvl",
            Context.MODE_PRIVATE
        )
        return SharedPreferencesSettings(prefs)
    }
}