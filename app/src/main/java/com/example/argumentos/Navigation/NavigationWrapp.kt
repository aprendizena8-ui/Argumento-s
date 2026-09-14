package com.example.argumentos.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavDisplay
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.argumentos.Screens.*

@Composable
fun NavigationWrapp() {
    val backStack = rememberNavBackStack(elements = Routes.Prueba_1)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Prueba_1> {
                Argumentos(
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

                        backStack.add(Routes.CartScreen)
                    }
                )
            }


            entry<Routes.CartScreen> {
                CartScreen(
                    cartItems = emptyList(),
                    totalPrice = 0.0,
                    onRemoveItem = {},
                    onClearCart = {},
                    onCheckout = {}
                )
            }
        }
    )
}