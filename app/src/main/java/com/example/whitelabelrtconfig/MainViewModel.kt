package com.example.whitelabelrtconfig

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.WhiteLabelConfigUtil
import com.example.data.WhiteLabelConfiguration
import com.example.data.models.WhiteLabelConfigTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class MainViewModel @Inject constructor(
    private val jsonConfig: WhiteLabelConfigUtil
): ViewModel() {

    private val _uiState: MutableStateFlow<WhiteLabelUi> = MutableStateFlow(WhiteLabelUi())
    val uiState = _uiState.asStateFlow()

    private val _themeUiState: MutableStateFlow<WhiteLabelConfigTheme> = MutableStateFlow(WhiteLabelConfigTheme())
    val themeUiState = _themeUiState.asStateFlow()

    init {
        getWhiteLabelTheme("app_config3.json")
    }
    fun getWhiteLabelConfigData(fileName: String) {
        viewModelScope.launch {
            val data = viewModelScope.async {
                jsonConfig.getColorHexCode(fileName)
            }.await()
            val style = data.style
            val uiData = WhiteLabelUi(
                bgColor = style.baseColor,
                b1Color = style.button1Color,
                b2Color = style.button2Color,
                textColor = style.baseColor,
                text = style.text1,
                shouldShowUi = style.shouldShowText
            )
            println("xxxxx log json = $uiData")
            _uiState.update { uiData }
        }
    }

    fun getWhiteLabelTheme(fileName: String) {
        viewModelScope.launch {
            val data = jsonConfig.getWhiteLabelThemeFrom(fileName)
            _themeUiState.update { data }
        }
    }

    fun clientAButtonClick() {
        getWhiteLabelConfigData("app_config.json")
    }

    fun clientBButtonClick() {
        getWhiteLabelConfigData("app_config2.json")
    }
}
