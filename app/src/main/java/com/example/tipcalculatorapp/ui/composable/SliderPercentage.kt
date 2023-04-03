package com.example.tipcalculatorapp.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun SliderPercentage(onSliderValueChange: (Int) -> Unit) {
    var sliderValue = 0f;

   Surface(modifier = Modifier.padding(10.dp)) {
       Column() {
           Slider(
               value = sliderValue,
               onValueChange = { newValue ->
                   sliderValue = newValue
                   onSliderValueChange(newValue.roundToInt() * 5)

               },
               valueRange = 0f..20f,
               steps = 20
           )
           Text(text = "Your Tip is: ${sliderValue.roundToInt() * 5}%")
       }
    }

}

@Preview
@Composable
fun SliderPercentagePreview() {
    SliderPercentage {

    }
}