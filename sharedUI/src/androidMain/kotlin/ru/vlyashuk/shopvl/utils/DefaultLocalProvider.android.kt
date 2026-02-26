package ru.vlyashuk.shopvl.utils

import java.util.Locale

actual fun getDefaultLocale(): String {
    return Locale.getDefault().toString()
}