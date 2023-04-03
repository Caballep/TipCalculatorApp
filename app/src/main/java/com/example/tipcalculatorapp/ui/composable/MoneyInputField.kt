package com.example.tipcalculatorapp.ui.composable

import android.text.TextUtils
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalComposeUiApi
@Composable
fun MoneyInputField(
    onValueChange: (Int) -> Unit
) {
    val valueState = remember {
        mutableStateOf("")
    }
    val validState = valueState.value.trim().isNotEmpty()
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valueState.value,
        onValueChange = {
            if (TextUtils.isDigitsOnly(it)) {
                valueState.value = it
            } else {
                valueState.value = ""
            }
        },
        label = { Text(text = "Purchase Amount") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.ArrowForward,
                contentDescription = "Purchase Amount Icon"
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions {
            if (!validState) return@KeyboardActions // keyboard will stay if enter is pressed and validState is false
            keyboardController?.hide()
            onValueChange(valueState.value.toInt())
        }
    )
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun MoneyInputFieldPreview() {
    MoneyInputField {

    }
}
