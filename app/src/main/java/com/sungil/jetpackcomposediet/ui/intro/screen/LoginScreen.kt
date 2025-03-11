package com.sungil.jetpackcomposediet.ui.intro.screen

import android.widget.NumberPicker.OnValueChangeListener
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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sungil.jetpackcomposediet.R

@Composable
internal fun LoginScreen(
    onLogin : (String , String) -> Unit,
    onSignUp : (String , String) -> Unit,
    errorMessage : String?
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            if (email.isEmpty()) {
                Text(
                    text = "email",
                    color = Color.Gray,
                    style = TextStyle(fontSize = 16.sp)
                )
            }

            BasicTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            if (password.isEmpty()) {
                Text(
                    text = "password",
                    color = Color.Gray,
                    style = TextStyle(fontSize = 16.sp)
                )
            }

            BasicTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth().
            padding(start = 8.dp , end = 8.dp , top = 10.dp ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            ),
            onClick = {}
        ) {
            Text(
                text = "Login",
                color = Color.White
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth().
            padding(start = 8.dp , end = 8.dp , top = 10.dp ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            onClick = {}
        ) {
            Text(
                text = "Sign up",
                color = Color.White
            )
        }
    }

}


@Preview
@Composable
fun preview() {
    LoginScreen()
}