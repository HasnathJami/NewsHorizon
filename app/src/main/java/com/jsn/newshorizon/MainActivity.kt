package com.jsn.newshorizon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.jsn.newshorizon.presentation.onboarding.OnBoardingScreen
import com.jsn.newshorizon.presentation.onboarding.OnBoardingViewModel
import com.jsn.newshorizon.ui.theme.NewsHorizonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            NewsHorizonTheme {
                val boardingScreenViewModel = hiltViewModel<OnBoardingViewModel>()
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen(
                       // event = boardingScreenViewModel::onEvent
                        event = { value ->
                            boardingScreenViewModel.onEvent(value)
                        }


                    )
                }
            }
        }

    }
}

@Composable
fun PreviewScreen(name: String, modifier: Modifier = Modifier) {
    OnBoardingScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsHorizonTheme {
        OnBoardingScreen()
    }
}