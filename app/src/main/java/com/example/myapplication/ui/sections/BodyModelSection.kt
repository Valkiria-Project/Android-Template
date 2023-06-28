package com.example.myapplication.ui.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.domain.deviceauth.model.BodyRowModel
import com.example.myapplication.domain.deviceauth.model.LabelModel
import com.example.myapplication.domain.deviceauth.model.TextFieldModel
import com.example.myapplication.ui.components.Label
import com.example.myapplication.ui.components.TextFieldComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyModelSection(
    body: List<BodyRowModel>?,
    modifier: Modifier
) {
    if (body?.isNotEmpty() == true) {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            body.map { bodyRow ->
                when (bodyRow) {
                    is LabelModel -> item {
                        Label(label = bodyRow, modifier = modifier)
                    }

                    is TextFieldModel -> item {
                        TextFieldComponent(textFieldModel = bodyRow, modifier = modifier)
                    }
                }
            }
        }
    }
}
