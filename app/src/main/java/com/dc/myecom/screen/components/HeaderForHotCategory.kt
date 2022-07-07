package com.dc.myecom.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderForHotCategory() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "HOT CATEGORIES")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "VIEW ALL >")
    }
}