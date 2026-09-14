package com.example.argumentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.argumentos.Navigation.NavigationWrapp
import com.example.argumentos.ui.theme.ArgumentosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArgumentosTheme {
                NavigationWrapp()
            }
        }
    }
}
