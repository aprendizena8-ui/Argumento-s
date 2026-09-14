package com.example.argumentos.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.argumentos.Models.Producto
import com.example.argumentos.Screens.CapturarDatos
import com.example.argumentos.Screens.CartScreen
import com.example.argumentos.Screens.ProductDetailScreen
import com.example.argumentos.Screens.ProductListScreen
import com.example.argumentos.Screens.Prueba_1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationWrapp() {
    val backStack = rememberNavBackStack(Routes.Prueba_1)
    val cartItems = remember { mutableStateListOf<Producto>() }

    // Evaluamos la ruta actual
    val currentRoute = backStack.lastOrNull()

    // Solo mostramos la TopAppBar si no estamos en el Login ni en CapturarDatos
    val showTopBar = currentRoute !is Routes.Prueba_1 && currentRoute !is Routes.CapturarDatos

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopAppBar(
                    title = { Text("Mi Tienda") },
                    actions = {
                        BadgedBox(
                            badge = {
                                if (cartItems.isNotEmpty()) {
                                    Badge { Text("${cartItems.size}") }
                                }
                            }
                        ) {
                            IconButton(onClick = { backStack.add(Routes.CartScreen) }) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingCart,
                                    contentDescription = "Ver Carrito"
                                )
                            }
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Routes.Prueba_1> {
                    Prueba_1(
                        onNextScreen = { usuario, pass ->
                            backStack.add(Routes.CapturarDatos(user = usuario, pass = pass))
                        }
                    )
                }

                entry<Routes.CapturarDatos> { key ->
                    CapturarDatos(
                        user = key.user,
                        pass = key.pass,
                        onExploreClick = {
                            backStack.add(Routes.ProductListScreen)
                        }
                    )
                }

                entry<Routes.ProductListScreen> {
                    ProductListScreen(
                        onProductClick = { product ->
                            backStack.add(Routes.ProductDetailScreen(product = product))
                        }
                    )
                }

                entry<Routes.ProductDetailScreen> { key ->
                    ProductDetailScreen(
                        product = key.product,
                        onAddToCart = { product ->
                            cartItems.add(product)
                            backStack.add(Routes.CartScreen)
                        }
                    )
                }

                entry<Routes.CartScreen> {
                    CartScreen(
                        cartItems = cartItems,
                        totalPrice = cartItems.sumOf { it.price },
                        onRemoveItem = { item -> cartItems.remove(item) },
                        onClearCart = { cartItems.clear() },
                        onCheckout = { /* Acción de compra */ }
                    )
                }
            }
        )
    }
}