package com.sungil.jetpackcomposediet.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomEditText(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    isPassword: Boolean,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
    hintStyle: TextStyle = TextStyle(color = Color.Gray, fontSize = 16.sp),
    backgroundColor: Color = Color.LightGray,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .background(backgroundColor, shape)
            .padding(16.dp)
    ) {
        if (value.isEmpty()) {
            Text(
                text = hint,
                style = hintStyle
            )
        }
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = textStyle,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        onClick = onClick
    ) {
        Text(
            text = text,
            color = contentColor
        )
    }
}