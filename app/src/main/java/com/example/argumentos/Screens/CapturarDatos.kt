package com.example.argumentos.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun CapturarDatos( user : String , pass : String){
    Column() {
        Text( text = "Primer dato $user")
        Text( text = "Segundo dato $pass")
    }
}