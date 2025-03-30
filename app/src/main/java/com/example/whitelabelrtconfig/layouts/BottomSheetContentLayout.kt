package com.example.whitelabelrtconfig.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.whitelabelrtconfig.CustomButton

@Composable
fun BottomSheetContentLayout() {
    /*Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.primary,
        bottomBar = {
            Spacer(
                modifier = Modifier
                    .background(Color.Black)
                    .navigationBarsPadding()
                    .fillMaxWidth()
            )
        }
    ) { paddingValues ->
        // when sheet content added inside scaffold, it swipe up to top of screen.
        BottomSheetContent()
    }*/
    BottomSheetContent()
}

@Composable
fun BottomSheetContent() {
    Column(
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.5f)
            .navigationBarsPadding()
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        CustomButton(
            text = "Create Account",
            onClick = { /* Handle Click */ },
            backgroundColor = MaterialTheme.colorScheme.secondary,  // Change Background Color
            textColor = MaterialTheme.colorScheme.background,     // Change Text Color
            cornerRadius = 25,            // Change Corner Radius
            fontSize = 20,                // Change Font Size
            fontWeight = FontWeight.Medium // Change Font Weight
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomButton(
            text = "Login",
            onClick = { /* Handle Click */ },
            backgroundColor = MaterialTheme.colorScheme.secondary,  // Change Background Color
            textColor = MaterialTheme.colorScheme.background,     // Change Text Color
            cornerRadius = 25,            // Change Corner Radius
            fontSize = 20,                // Change Font Size
            fontWeight = FontWeight.Medium, // Change Font Weight
            borderColor = MaterialTheme.colorScheme.primary,
            borderWidth = 1
        )

        Spacer(modifier = Modifier.height(50.dp))

//            if (uiState.shouldShowUi) {
        CustomButton(
            text = "Find Near Chargers",
            onClick = { /* Handle Click */ },
            backgroundColor = MaterialTheme.colorScheme.secondary,  // Change Background Color
            textColor = MaterialTheme.colorScheme.background,     // Change Text Color
            cornerRadius = 15,            // Change Corner Radius
            fontSize = 20,                // Change Font Size
            fontWeight = FontWeight.Medium // Change Font Weight
        )
//            }

    }
}