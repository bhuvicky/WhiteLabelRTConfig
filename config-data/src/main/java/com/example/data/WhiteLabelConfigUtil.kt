package com.example.data


import android.content.Context
import com.example.data.di.IoDispatcher
import com.example.data.models.WhiteLabelConfigTheme
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class WhiteLabelConfigUtil(
    @ApplicationContext private val applicationContext: Context,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,

    ) {


    suspend fun getColorHexCode(fileName: String) =
        withContext(dispatcher) {
            val json = applicationContext.assets.open(fileName).bufferedReader().use { it.readText() }
            Gson().fromJson(json, WhiteLabelConfiguration::class.java)
        }

    suspend fun getWhiteLabelThemeFrom(json: String) =
        withContext(dispatcher) {
            val json = applicationContext.assets.open(json).bufferedReader().use { it.readText() }
            Gson().fromJson(json, WhiteLabelConfigTheme::class.java)
        }

}
