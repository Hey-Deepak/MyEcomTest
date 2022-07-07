package com.dc.myecom.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HeaderForTopCategory() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        
    ) {
        Text(text = "TOP CATEGORIES")
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "VIEW ALL >")
    }
}