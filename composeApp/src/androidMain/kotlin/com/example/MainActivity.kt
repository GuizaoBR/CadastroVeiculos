package com.example

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import data.DriverFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(
                DriverFactory(LocalContext.current.applicationContext).createDriver()
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(DriverFactory(LocalContext.current.applicationContext).createDriver())
}