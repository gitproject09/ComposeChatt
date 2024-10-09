package com.supan.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.supan.presentation.theme.Purple500

@Composable
fun AppOutlinedTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintColor: Color,
    focusedBorderColor: Color,
    unfocusedBorderColor: Color,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor
        ),
        label = { Text(text = hint, color = hintColor) }
    )
}


@Composable
fun AppOutlinedTextFieldPassword(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    hintColor: Color,
    focusedBorderColor: Color,
    unfocusedBorderColor: Color,
    visualTransformation: VisualTransformation,
    trailingIcon: @Composable() (() -> Unit)

) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor
        ),
        label = { Text(text = hint, color = hintColor) },
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon
    )
}

@Composable
fun SearchTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable() () -> Unit,
    trailingIcon: @Composable() () -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Purple500),
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        singleLine = true,
        trailingIcon = trailingIcon,
        textStyle = TextStyle(
            color = Color.White
        ),
    )
}