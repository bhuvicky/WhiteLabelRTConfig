package com.example.whitelabelrtconfig

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.data.WhiteLabelConfigUtil
import com.example.whitelabelrtconfig.layouts.MapWithBottomSheetLayout
import com.example.whitelabelrtconfig.ui.theme.LocalRtTheme
import com.example.whitelabelrtconfig.ui.theme.WhiteLabelRTConfigTheme
import com.example.whitelabelrtconfig.ui.theme.WhiteLabelRTTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val jsonConfig: MainViewModel by viewModels()
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val themeState by jsonConfig.themeUiState.collectAsState()

            WhiteLabelRTTheme(themeState) {
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapWithBottomSheetLayout()
                }*/
                MapWithBottomSheetLayout()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WhiteLabelRTConfigTheme {
        Greeting("Android")
    }
}