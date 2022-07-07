package com.dc.myecom.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.dc.myecom.model.homebanner.HomeBanner
import com.dc.myecom.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeBanner() {

    val viewModel = MainViewModel()
    viewModel.getAllHomeBanner()
    val state = rememberPagerState(pageCount = viewModel.homeBannerResponse.data.size)
    val imageUrl =
        remember { mutableStateOf("") }
    HorizontalPager(
        state = state,
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) { page ->
        imageUrl.value = viewModel.homeBannerResponse.data[page].var_image

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.BottomCenter) {

                val painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl.value)
                        .build()
                    // TODO
                )
                Image(
                    painter = painter, contentDescription = "", Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxSize(), contentScale = ContentScale.Crop
                )

            }
        }
    }
    LaunchedEffect(key1 = state.currentPage) {
        delay(3000)
        var newPosition = state.currentPage + 1
        if (newPosition > viewModel.homeBannerResponse.data.size - 1) newPosition = 0
        // scrolling to the new position.
        state.animateScrollToPage(newPosition)
    }

}