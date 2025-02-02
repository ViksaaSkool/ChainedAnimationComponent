package com.viksaaskool.chainedanimation.ui


import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.viksaaskool.chainedanimation.ui.screens.AppNavHost
import com.viksaaskool.chainedanimation.ui.theme.ChainedAnimationDemoTheme


object Routes {
    const val HOME_SCREEN = "home"
    const val DEMO1_SCREEN = "demo1"
    const val DEMO2_SCREEN = "demo2"
}

@Composable
fun Int.getString() = stringResource(id = this)

@Composable
fun Int.getPainter() = painterResource(id = this)

@Composable
fun Int.getVector() = ImageVector.vectorResource(id = this)


/**
 * Add padding to the top of the screen to account for the system bars.
 */
fun ComponentActivity.handleEdgeToEdge(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    enableEdgeToEdge()
    setContent {
        ChainedAnimationDemoTheme(darkTheme = darkTheme) {
            content()
        }
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(true) {
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = !darkTheme,
            )
            systemUiController.setNavigationBarColor(
                color = Color.Transparent,
                darkIcons = !darkTheme
            )
        }
    }
}

