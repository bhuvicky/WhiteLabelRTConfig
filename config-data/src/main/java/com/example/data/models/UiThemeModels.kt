package com.example.data.models

import com.google.gson.annotations.SerializedName

data class WhiteLabelConfigTheme(
    val cpTypography: CPTypography = CPTypography(),
    val darkColorScheme: DarkColorScheme = DarkColorScheme(),
    val lightColorScheme: LightColorScheme = LightColorScheme()
)
data class CPTypography (

    @SerializedName("bodyLarge" ) var bodyLarge : BodyLarge? = BodyLarge()

)

data class DarkColorScheme (

    @SerializedName("primary_purple80"       ) var primaryPurple80       : String = "#00000000",
    @SerializedName("secondary_purpleGrey80" ) var secondaryPurpleGrey80 : String = "#00000000",
    @SerializedName("tertiary_pink80"        ) var tertiaryPink80        : String = "#00000000",
    @SerializedName("surface"                ) var surface        : String = "#00000000",
    @SerializedName("background"             ) var background        : String = "#00000000",

)

data class LightColorScheme (

    @SerializedName("primary_purple40"       ) var primaryPurple40       : String = "#00000000",
    @SerializedName("secondary_purpleGrey40" ) var secondaryPurpleGrey40 : String = "#00000000",
    @SerializedName("tertiary_pink40"        ) var tertiaryPink40        : String = "#00000000",
    @SerializedName("surface"                ) var surface        : String = "#00000000",
    @SerializedName("background"             ) var background        : String = "#00000000",

)

data class BodyLarge (

    @SerializedName("fontFamily"    ) var fontFamily    : String = "Default",
    @SerializedName("fontWeight"    ) var fontWeight    : String = "Normal",
    @SerializedName("fontSize"      ) var fontSize      : Int    = 15,
    @SerializedName("letterSpacing" ) var letterSpacing : Double = 0.5

)