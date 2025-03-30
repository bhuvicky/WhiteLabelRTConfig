package com.example.whitelabelrtconfig

import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@Composable
fun MainLayout2() {
    val pair = listOf(
        Pair(R.drawable.image2, "Smo0th onboarding to charge yourself")
    )
    val pagerState = rememberPagerState(pageCount = { pair.size } )
    val context = LocalContext.current
//    val icon = context.resources.getIdentifier()
//    val viewModel = hiltViewModel<MainViewModel>()
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        println("xxxx log layout2")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary),
            verticalAlignment = Alignment.Top
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            ) { page ->
                Image(
                    painter = painterResource(id = pair[page].first),
                    contentDescription = "Image $page",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dots Indicator
        Row(
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pair.size) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(4.dp)
                        .then(
                            Modifier
                                .background(
                                    color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.tertiary,
                                    shape = CircleShape
                                )
                        )
                )
            }
        }
        /*HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp),
            activeColor = MaterialTheme.colorScheme.primary,
            inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            indicatorShape = CircleShape
        )*/

        Spacer(modifier = Modifier.height(16.dp))

        // Dynamic Text (Changes with Slide)
        Text(
            text = "Charge with different type of charger",
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = MaterialTheme.colorScheme.surface,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
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
}