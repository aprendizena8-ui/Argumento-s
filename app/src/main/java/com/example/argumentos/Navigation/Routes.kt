package com.example.argumentos.Navigation

import androidx.navigation.NavKey
import com.example.argumentos.Models.Producto
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes()

    @Serializable
    data class CapturarDatos(
        val user: String,
        val pass: String
    ) : Routes()

    @Serializable
    data class detailProducto(
        val id: Int
    ) : Routes()

    @Serializable
    data class detailProductRoute(
        val producto: Producto,
        val isInCart: Boolean
    ) : Routes()

    @Serializable
    data class CartScreen(
        val producto: List<Producto>,
        val totalPrice: Double
    ) : Routes()

    @Serializable
    data class ProductListScreen(
        val user: String,
        val pass: String,
        val producto: List<Producto>
    ) : Routes()

    // @Serializable
    // data class detailProductRoute( val producto: Producto) : Routes()
}