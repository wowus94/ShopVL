package ru.vlyashuk.shopvl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.stringResource
import ru.vlyashuk.shopvl.theme.AppTheme
import shopvl.sharedui.generated.resources.IndieFlower_Regular
import shopvl.sharedui.generated.resources.Res
import shopvl.sharedui.generated.resources.hello_world

@Preview
@Composable
fun App(
    onThemeChanged: @Composable (isDark: Boolean) -> Unit = {}
) = AppTheme(onThemeChanged) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(Res.string.hello_world),
            fontFamily = FontFamily(Font(Res.font.IndieFlower_Regular)),
            style = MaterialTheme.typography.displayLarge
        )
    }
}
