package com.example.argumentos.Navigation

import androidx.navigation.NavKey
import com.example.argumentos.Models.Producto
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {
    @Serializable
    data object Prueba_1 : Routes()

    @Serializable
    data class CapturarDatos(
        val user: String,
        val pass: String
    ) : Routes()

    @Serializable
    data object ProductListScreen : Routes()

    @Serializable
    data class ProductDetailScreen(
        val product: Producto
    ) : Routes()

    @Serializable
    data object CartScreen : Routes()
}