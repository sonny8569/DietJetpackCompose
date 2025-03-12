package com.sungil.jetpackcomposediet.ui.intro.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sungil.jetpackcomposediet.R
import com.sungil.jetpackcomposediet.ui.CustomButton
import com.sungil.jetpackcomposediet.ui.CustomEditText
import kotlinx.coroutines.launch

@Composable
internal fun LoginScreen(
    onLogin: (String, String) -> Unit,
    onSignUp: (String, String) -> Unit,
    errorMessage: String?
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val snackBarHost = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_intro),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(top = 100.dp, bottom = 32.dp)
                .size(100.dp)
                .clip(RoundedCornerShape(100.dp))
        )

        CustomEditText(
            value = email,
            onValueChange = { email = it },
            hint = "email",
            isPassword = false
        )

        CustomEditText(
            value = password,
            onValueChange = { password = it },
            hint = "password",
            isPassword = true
        )

        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(10.dp),
                fontSize = 16.sp
            )
        }

        val showSnackbar: (String) -> Unit = { message ->
            coroutineScope.launch {
                snackBarHost.showSnackbar(
                    message,
                    duration = SnackbarDuration.Short
                )
            }
        }

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 10.dp),
            text = "Login",
            onClick = {
                if (email.isEmpty() || password.isEmpty()) {
                    showSnackbar("아이디와 비밀번호를 입력해주세요")
                    return@CustomButton
                }
                onLogin(email, password)
            },
            backgroundColor = Color.Blue
        )

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 10.dp),
            text = "Sign up",
            onClick = {
                if (email.isEmpty() || password.isEmpty()) {
                    showSnackbar("아이디와 비밀번호를 입력해주세요")
                    return@CustomButton
                }
                onSignUp(email, password)
            },
            backgroundColor = Color.Gray
        )

        LaunchedEffect(errorMessage) {
            errorMessage?.let { message ->
                coroutineScope.launch {
                    snackBarHost.currentSnackbarData?.dismiss()
                    snackBarHost.showSnackbar(
                        message,
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }

        SnackbarHost(hostState = snackBarHost)
    }
}