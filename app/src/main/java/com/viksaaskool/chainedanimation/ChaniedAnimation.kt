package com.viksaaskool.chainedanimation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

const val DEFAULT_ANIMATION_DURATION = 1000

/**
 * A composable function that provides a chained animation effect.
 * The default effect mimics teleprompter-like animations.
 *
 * @param visible A Boolean value that determines whether the content is visible.
 * @param onAnimationEnd A lambda function that is called when the animation ends. Default is an empty lambda.
 * @param duration The duration of the enter animation in milliseconds. Default is [DEFAULT_ANIMATION_DURATION].
 * @param enter The enter transition animation. Default is [defaultStartScreenInAnimation].
 * @param exit The exit transition animation. Default is [defaultStartScreenOutAnimation].
 * @param triggerNextAnimation A lambda function that triggers the next animation after a delay. Default is an empty lambda.
 * @param content A composable function that defines the content to be animated.
 */
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChainedAnimationComponent(
    visible: Boolean,
    onAnimationEnd: () -> Unit = {},
    duration: Int = DEFAULT_ANIMATION_DURATION,
    enter: EnterTransition = defaultStartScreenInAnimation(duration),
    exit: ExitTransition = defaultStartScreenOutAnimation(),
    triggerNextAnimation: () -> Unit = {},
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    var hasAnimationEnded by remember { mutableStateOf(false) }

    AnimatedVisibility(visible = visible, enter = enter, exit = exit) {
        content()
        if (hasAnimationEnded) {
            coroutineScope.launch {
                delay(300.milliseconds)
                triggerNextAnimation()
            }
        }
        with(transition) {
            if (currentState == targetState) {
                onAnimationEnd()
                hasAnimationEnded = true
            }
        }
    }

}

private fun defaultStartScreenInAnimation(duration: Int) =
    slideInVertically(animationSpec = tween(duration), initialOffsetY = {
        it / 2
    }) + fadeIn()

private fun defaultStartScreenOutAnimation() = fadeOut()

