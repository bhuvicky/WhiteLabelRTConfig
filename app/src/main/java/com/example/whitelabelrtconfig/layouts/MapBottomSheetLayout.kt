package com.example.whitelabelrtconfig.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.whitelabelrtconfig.CustomButton
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapWithBottomSheetLayout() {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
        )
    )
    val systemUiController = rememberSystemUiController()
    systemUiController.setNavigationBarColor(Color.Transparent)
    // Make bottom sheet content above NAV BAR;;; NOT REQ
//    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 16.dp

    println("xxxx log sheetState currentValue1 = ${scaffoldState.bottomSheetState.currentValue}")

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 192.dp,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetContent = { BottomSheetContentLayout() },
        sheetContainerColor = MaterialTheme.colorScheme.primary,
//        sheetDragHandle = { DragHandle() }
    ) {
        ScreenContent()
    }
//    var previousState by remember { mutableStateOf(scaffoldState.bottomSheetState.currentValue) }

    LaunchedEffect(scaffoldState.bottomSheetState) {
        coroutineScope.launch {
            val sheetState = scaffoldState.bottomSheetState
            println("xxxx log sheetState currentValue2 = ${sheetState.currentValue}")
            when (sheetState.currentValue) {
                SheetValue.Hidden -> {
//                    sheetState.partialExpand() // First swipe goes to partial
                }
                SheetValue.PartiallyExpanded -> {
                    sheetState.
//                    sheetState.hide() // Second swipe goes to fully expanded
                }
                SheetValue.Expanded -> {
//                    sheetState.partialExpand() // Swipe down from expanded to partial
                }
            }
        }
    }
}

@Composable
private fun DragHandle() {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(50.dp)
            .height(6.dp)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.primary)
//            .align(Alignment.Center)
    )
}

@Composable
private fun ScreenContent() {
    MainLayoutForBS()
}

