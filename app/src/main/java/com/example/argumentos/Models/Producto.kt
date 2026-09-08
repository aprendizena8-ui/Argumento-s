package com.example.argumentos.Models
import kotlinx.serialization.Serializable
@Serializable
data class Producto (
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String
){

}