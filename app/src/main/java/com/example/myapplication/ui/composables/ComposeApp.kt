package com.example.myapplication.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.MyViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun ComposeApp() {
    val myViewModel = hiltViewModel<MyViewModel>()

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { myViewModel.doSomething() }
        ) {
            Text(text = "Make request")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeAppPreview() {
    MyApplicationTheme {
        ComposeApp()
    }
}
