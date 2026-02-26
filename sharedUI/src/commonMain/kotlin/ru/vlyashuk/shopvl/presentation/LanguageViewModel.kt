package ru.vlyashuk.shopvl.presentation

import androidx.lifecycle.ViewModel
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.vlyashuk.shopvl.utils.getDefaultLocale

class LanguageViewModel(
    private val settings: Settings
) : ViewModel() {

    private val languageCodeKey = "languageCode"

    private val _languageCode = MutableStateFlow(
        settings.getStringOrNull(languageCodeKey) ?: getDefaultLocale()
    )
    val languageCode: StateFlow<String> = _languageCode.asStateFlow()

    fun switchLanguage(languageCode: String) {
        settings[languageCodeKey] = languageCode
        _languageCode.value = languageCode
    }
}