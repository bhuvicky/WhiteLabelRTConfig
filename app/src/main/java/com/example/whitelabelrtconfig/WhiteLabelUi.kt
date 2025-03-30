package com.example.whitelabelrtconfig

import androidx.compose.ui.graphics.Color

data class WhiteLabelUi(
    val bgColor: String = "#00000000",
    val b1Color: String = "#00000000",
    val b2Color: String = "#00000000",
    val textColor: String = "#00000000",
    val text: String = "",
    val shouldShowUi: Boolean = true
)

fun String.parseColor(): Color {
    return Color(android.graphics.Color.parseColor(this))
}