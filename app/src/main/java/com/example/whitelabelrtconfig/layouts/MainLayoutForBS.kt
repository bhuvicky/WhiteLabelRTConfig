package com.example.whitelabelrtconfig.layouts

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whitelabelrtconfig.R

@Composable
fun MainLayoutForBS() {
    val pair = listOf(
        Pair(R.drawable.image2, "Smo0th onboarding to charge yourself")
    )
    val pagerState = rememberPagerState(pageCount = { pair.size } )
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
    }
}