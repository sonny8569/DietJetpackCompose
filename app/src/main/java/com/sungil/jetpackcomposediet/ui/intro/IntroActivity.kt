package com.sungil.jetpackcomposediet.ui.intro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sungil.jetpackcomposediet.ui.intro.screen.LoginScreen

class IntroActivity : ComponentActivity() {
    private val viewModel: IntroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {

            val user by viewModel.authState.collectAsStateWithLifecycle()
            val error by viewModel.errorState.collectAsStateWithLifecycle()

            LoginScreen(
                onLogin = {email , password ->
                    viewModel.login(email, password)
                } ,
                onSignUp = { email , password ->
                    viewModel.singUp(email,password)
                },
                errorMessage = error
            )
        }
    }
}