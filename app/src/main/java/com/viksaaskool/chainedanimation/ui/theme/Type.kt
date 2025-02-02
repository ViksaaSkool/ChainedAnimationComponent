package com.viksaaskool.chainedanimation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.viksaaskool.chainedanimation.R


val bubbleBuddyFatFont = FontFamily(Font(R.font.bubbleboddy_fat))
val bubbleBuddyExtraLightFont = FontFamily(Font(R.font.bubbleboddy_extra_light))

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = bubbleBuddyFatFont,
        fontWeight = FontWeight.Normal,
        fontSize = 42.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = goldenYellow
    ),
    titleMedium = TextStyle(
        fontFamily = bubbleBuddyFatFont,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = goldenYellow
    ),
    bodyLarge = TextStyle(
        fontFamily = bubbleBuddyExtraLightFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = bubbleBuddyExtraLightFont,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.White
    )
)