package com.viksaaskool.chainedanimation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.viksaaskool.chainedanimation.ChainedAnimationComponent
import com.viksaaskool.chainedanimation.R
import com.viksaaskool.chainedanimation.ui.getString
import com.viksaaskool.chainedanimation.ui.theme.ChainedAnimationDemoTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun DemoScreen1() {

    var demo1ScreenState by remember { mutableStateOf(Demo1ScreenState()) }

    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopCenter)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier.height(72.dp))
            ChainedAnimationComponent(visible = demo1ScreenState.isTitle1Visible,
                triggerNextAnimation = {
                    demo1ScreenState = demo1ScreenState.copy(isSubTitle1Visible = true)
                }) {
                Text(
                    text = R.string.demo_1_title.getString(),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ChainedAnimationComponent(visible = demo1ScreenState.isSubTitle1Visible,
                triggerNextAnimation = {
                    demo1ScreenState = demo1ScreenState.copy(isP1Visible = true)
                }) {
                Text(
                    text = R.string.demo_1_subtitle.getString(),
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(48.dp))
            ChainedAnimationComponent(visible = demo1ScreenState.isP1Visible,
                triggerNextAnimation = {
                    demo1ScreenState = demo1ScreenState.copy(isP2Visible = true)
                }) {
                Text(
                    text = R.string.demo_1_p1.getString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ChainedAnimationComponent(visible = demo1ScreenState.isP2Visible,
                triggerNextAnimation = {
                    demo1ScreenState = demo1ScreenState.copy(isP3Visible = true)
                }) {
                Text(
                    text = R.string.demo_1_p2.getString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            ChainedAnimationComponent(visible = demo1ScreenState.isP3Visible) {
                Text(
                    text = R.string.demo_1_p3.getString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

        }

        LaunchedEffect(!demo1ScreenState.isTitle1Visible) {
            delay(1000.milliseconds)
            demo1ScreenState = demo1ScreenState.copy(isTitle1Visible = true)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DemoScreen1Preview() = ChainedAnimationDemoTheme(true) {
    DemoScreen1()
}