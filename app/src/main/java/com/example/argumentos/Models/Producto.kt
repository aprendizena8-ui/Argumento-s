package com.example.argumentos.Models

import com.example.argumentos.R
import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageRes: Int = R.drawable.productocarrito
)