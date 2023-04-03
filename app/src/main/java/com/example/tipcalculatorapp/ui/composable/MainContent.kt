package com.example.tipcalculatorapp.ui.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun MainContent(onOperationChange: (Double) -> Unit) {
    var money = 0
    var tip = 0
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(corner = CornerSize(8.dp)),
                color = Color.Gray
            )
    ) {
        Column(Modifier.padding(10.dp)) {
            MoneyInputField {
                money = it
                val total = (money * (tip / 100.0)) + money
                onOperationChange(total)
            }
            SliderPercentage {
                tip = it
                val total = (money * (tip / 100.0)) + money
                onOperationChange(total)
            }
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContentPreview() {
    MainContent{

    }
}