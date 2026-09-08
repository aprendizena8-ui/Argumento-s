package com.example.argumentos.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavDisplay
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import com.example.argumentos.Screens.Argumentos
import com.example.argumentos.Screens.CapturarDatos
import com.example.argumentos.Navigation.Routes

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
                CapturarDatos(key.user, key.pass)
            }
        }
    )
}