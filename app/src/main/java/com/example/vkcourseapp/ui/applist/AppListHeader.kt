package com.example.vkcourseapp.ui.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vkcourseapp.R


@Composable
fun AppListHeader() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color(0xFF0077FF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.rustore),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.view_comfy_alt_24px),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(end = 20.dp)
        )
    }
}