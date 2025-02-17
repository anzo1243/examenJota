package com.example.atun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.atun.navigation.AtunApp
import com.example.atun.ui.theme.AtunTheme
import com.example.atun.view.AtunScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AtunTheme {
                AtunApp()
            }
        }
    }
}
