package com.example.myapplication.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import com.example.myapplication.domain.deviceauth.model.TextFieldModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    textFieldModel: TextFieldModel,
    modifier: Modifier,
) {
    var text by remember { mutableStateOf(TextFieldValue(text = "")) }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        placeholder = {
            Text(text = textFieldModel.hint)
        }
    )
}
