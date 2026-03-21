package com.example.vkcourseapp.presentation.applist

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcourseapp.domain.applist.AppItemDto


@Composable
fun AppItem(
    appDetailsItem: AppItemDto,
    size: Dp,
    onClick: () -> Unit,
) {
    Row(Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        .clickable { onClick() }
        .background(Color(0xFFFFFFFF))) {
        Image(
            painter = painterResource(appDetailsItem.iconResId),
            contentDescription = null,
            modifier = Modifier
                .size(size)
                .padding(top = 8.dp),
        )
        Column(
        ) {
            Text(
                text = appDetailsItem.name,
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                text = appDetailsItem.description,
                modifier = Modifier.padding(4.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = appDetailsItem.category,
                modifier = Modifier.padding(4.dp),
                color = Color.Gray
            )
        }
    }
}

