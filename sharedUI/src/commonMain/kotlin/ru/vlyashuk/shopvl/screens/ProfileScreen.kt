package ru.vlyashuk.shopvl.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import ru.vlyashuk.shopvl.presentation.LanguageViewModel
import shopvl.sharedui.generated.resources.Res
import shopvl.sharedui.generated.resources.language

@Composable
fun ProfileScreen(
    languageViewModel: LanguageViewModel
) {
    val currentLanguage by languageViewModel.languageCode.collectAsState()

    val languages = listOf(
        "en" to "English",
        "ru" to "Русский"
    )

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            12.dp,
            Alignment.CenterVertically
        )
    ) {

        Text(
            text = stringResource(Res.string.language),
            style = MaterialTheme.typography.labelLarge
        )

        SingleChoiceSegmentedButtonRow {

            languages.forEachIndexed { index, (code, title) ->

                val selected = currentLanguage == code

                SegmentedButton(
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            languageViewModel.switchLanguage(code)
                        }
                    },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = languages.size
                    ),
                    icon = {
                        if (selected) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null
                            )
                        }
                    }
                ) {
                    Text(title)
                }
            }
        }
    }
}