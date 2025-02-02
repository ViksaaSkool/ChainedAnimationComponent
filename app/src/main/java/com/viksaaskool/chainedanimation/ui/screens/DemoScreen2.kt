package com.viksaaskool.chainedanimation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.viksaaskool.chainedanimation.ChainedAnimationComponent
import com.viksaaskool.chainedanimation.R
import com.viksaaskool.chainedanimation.ui.getPainter
import com.viksaaskool.chainedanimation.ui.getString
import com.viksaaskool.chainedanimation.ui.theme.ChainedAnimationDemoTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

const val ANIMATION_DURATION = 2000

@Composable
fun DemoScreen2() {
    var demo2ScreenState by remember { mutableStateOf(Demo2ScreenState()) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.coffee_animation_1))

    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ChainedAnimationComponent(visible = demo2ScreenState.isText1Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(isText1Visible = false)
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(isText2Visible = true)
                }) {
                Text(
                    text = R.string.demo_2_text1.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isText2Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText2Visible = false
                    )
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText3Visible = true
                    )
                }) {
                Text(
                    text = R.string.demo_2_text2.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isText3Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText3Visible = false
                    )
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isIllustration1Visible = true
                    )
                }) {
                Text(
                    text = R.string.demo_2_text3.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isIllustration1Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isIllustration1Visible = false
                    )
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText4Visible = true
                    )
                }) {
                Image(
                    painter = R.drawable.coffee_machine.getPainter(),
                    contentDescription = "coffee machine",
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isText4Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText4Visible = false
                    )
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText5Visible = true
                    )
                }) {
                Text(
                    text = R.string.demo_2_text4.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isText5Visible,
                duration = ANIMATION_DURATION,
                onAnimationEnd = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText5Visible = false
                    )
                },
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isIllustration2Visible = true
                    )
                }) {
                Text(
                    text = R.string.demo_2_text5.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }
            ChainedAnimationComponent(visible = demo2ScreenState.isIllustration2Visible,
                duration = ANIMATION_DURATION,
                triggerNextAnimation = {
                    demo2ScreenState = demo2ScreenState.copy(
                        isText6Visible = true
                    )
                }) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = R.string.demo_2_text5.getString(),
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                    LottieAnimation(
                        modifier = Modifier.size(400.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever
                    )
                }
            }
            ChainedAnimationComponent(
                visible = demo2ScreenState.isText6Visible,
                duration = ANIMATION_DURATION
            ) {
                Text(
                    text = R.string.demo_2_text6.getString(),
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
            }

        }

    }

    LaunchedEffect(Unit) {
        delay(1000.milliseconds)
        demo2ScreenState = demo2ScreenState.copy(isText1Visible = true)
    }
}


@Preview(showBackground = true)
@Composable
fun DemoScreen2Preview() = ChainedAnimationDemoTheme(true) {
    DemoScreen2()
}