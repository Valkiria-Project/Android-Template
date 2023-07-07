package com.example.uicomponents.payments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Suppress("UnusedPrivateMember", "LongParameterList")
@Composable
// XML or CustomView
fun PaymentMethodInfo(
    imageUrl: String,
    amountPaid: Double,
    rawAmount: Double,
    methodType: String,
    modifier: Modifier = Modifier,
    discount: String? = null
) {
    Column(Modifier.background(Color.White)) {
        Text(
            text = methodType,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = Color.Black.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )
        Text(
            text = methodType,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            color = Color.Black.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentMethodInfoPreview() {
    PaymentMethodInfo(
        imageUrl = "",
        amountPaid = 150.0,
        discount = "50% OFF",
        rawAmount = 180.0,
        methodType = "Dinheiro em conta Mercado Pago"
    )
}
