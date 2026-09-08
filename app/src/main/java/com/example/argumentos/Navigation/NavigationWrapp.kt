package com.example.argumentos.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavDisplay
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.argumentos.Screens.*

@Composable
fun NavigationWrapp() {  // ← MANTENEMOS EL NOMBRE "NavigationWrapp"
    val backStack = rememberNavBackStack(elements = Routes.Prueba_1)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            // Pantalla de Login (Prueba_1)
            entry<Routes.Prueba_1> {
                Argumentos(
                    onNextScreen = { usuario, pass ->
                        backStack.add(Routes.CapturarDatos(user = usuario, pass = pass))
                    }
                )
            }

            // Pantalla de Bienvenida (CapturarDatos)
            entry<Routes.CapturarDatos> { key ->
                CapturarDatos(
                    user = key.user,
                    pass = key.pass,
                    onExploreClick = {
                        backStack.add(Routes.ProductListScreen)
                    }
                )
            }

            // Pantalla de Lista de Productos
            entry<Routes.ProductListScreen> {
                ProductListScreen(
                    onProductClick = { product ->
                        backStack.add(Routes.ProductDetailScreen(product = product))
                    }
                )
            }

            // Pantalla de Detalle del Producto
            entry<Routes.ProductDetailScreen> { key ->
                ProductDetailScreen(
                    product = key.product,
                    onAddToCart = { product ->
                        // Aquí agregas la lógica para añadir al carrito
                        backStack.add(Routes.CartScreen)
                    }
                )
            }

            // Pantalla de Carrito
            entry<Routes.CartScreen> {
                CartScreen(
                    cartItems = emptyList(),  // Aquí pasas los productos del carrito
                    totalPrice = 0.0,
                    onRemoveItem = {},
                    onClearCart = {},
                    onCheckout = {}
                )
            }
        }
    )
}