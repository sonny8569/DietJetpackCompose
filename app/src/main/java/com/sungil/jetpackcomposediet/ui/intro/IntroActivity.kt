package com.sungil.jetpackcomposediet.ui.intro

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sungil.jetpackcomposediet.MainActivity
import com.sungil.jetpackcomposediet.ui.intro.screen.LoginScreen

class IntroActivity : ComponentActivity() {
    private val viewModel: IntroViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            val context = LocalContext.current
            val user by viewModel.authState.collectAsStateWithLifecycle()
            val error by viewModel.errorState.collectAsStateWithLifecycle()
            when (user) {
                null -> {
                    LoginScreen(
                        onLogin = { email, password ->
                            viewModel.login(email, password)
                        },
                        onSignUp = { email, password ->
                            viewModel.singUp(email, password)
                        },
                        errorMessage = error
                    )
                }

                else -> {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                    finish()
                }
            }
        }
    }
}
