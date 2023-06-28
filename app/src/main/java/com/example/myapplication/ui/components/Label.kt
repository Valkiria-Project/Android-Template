package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.deviceauth.model.LabelModel

@Composable
fun Label(
    label: LabelModel,
    modifier: Modifier
) {
    Text(
        text = label.text,
        textAlign = TextAlign.Center,
        modifier = modifier.width(150.dp)
    )
}