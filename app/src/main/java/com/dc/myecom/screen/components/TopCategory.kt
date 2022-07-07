package com.dc.myecom.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dc.myecom.viewmodel.TopCategoryViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopCategory() {
    val viewModel = TopCategoryViewModel()
    viewModel.getTopCategory()
    Box(
        modifier = Modifier.fillMaxHeight(0.6f)
    ) {
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {


            items(viewModel.topCategoryResponse.data) { item ->

                Column(
                    modifier = Modifier.wrapContentHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .border(BorderStroke(1.dp, Color.Blue)),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(model = item.var_icon, contentDescription = "")

                    }
                    Text(text = item.var_title)
                }
            }
        }
    }

}