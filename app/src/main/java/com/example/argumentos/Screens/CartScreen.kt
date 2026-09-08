package com.example.argumentos.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CartScren( cartItems : List<Producto>,
){

}

@Preview
@Composable
fun previewCartScreen(){
    val producto = listOf(
        Producto
            (1, "Auriculares Bluetooth", 59.99," Cancelacion de ruido activa, 30h de bateria", ""
        )
    )
}