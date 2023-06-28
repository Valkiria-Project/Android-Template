package com.example.myapplication.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.domain.deviceauth.model.ButtonModel
import com.example.myapplication.domain.myscreen.model.Button

@Composable
fun FooterModelSection(
    leftButtonModel: ButtonModel?,
    rightButtonModel: ButtonModel?,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        leftButtonModel?.let { leftButtonModel ->
            Button(
                onClick = { onClick.invoke() }
            ) {
                Text(text = leftButtonModel.label)
            }
        }
        rightButtonModel?.let { rightButtonModel ->
            Button(
                onClick = { onClick.invoke() }
            ) {
                Text(text = rightButtonModel.label)
            }
        }
    }
}
