package com.example.composepractice.screen.pagers.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.R
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerDemo() {
    val pagerState = rememberPagerState(pageCount =  { 3 })

    LaunchedEffect(pagerState) {
        //collect from the snapshotFlow reading the currentPage
        snapshotFlow { pagerState.currentPage }.collect() { page ->
            //do something when the page changes, for example:
            //viewModel.sendPageSelectedEvent(page)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()) { page ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    painter = painterResource(getImage(page)),
                    contentScale = ContentScale.Fit,
                    contentDescription = "landscapes")
                Text(text = "Page ${page + 1}", fontSize = 24.sp)
            }
        }

        //custom pager indicator
        PagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

//Selecting the pictures according to the page number
fun getImage(page: Int): Int {
    return when(page%3) {
        0 -> R.drawable.l1
        1 -> R.drawable.l2
        else -> R.drawable.l3
    }
}