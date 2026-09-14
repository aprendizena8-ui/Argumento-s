package com.example.argumentos.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Prueba_1(
    onNextScreen: (String, String) -> Unit
) {
    var usuario by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = {
                usuario = it
                errorMessage = ""
            },
            label = { Text("Usuario") },
            isError = errorMessage.isNotEmpty(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = {
                pass = it
                errorMessage = ""
            },
            label = { Text("Contraseña") },
            isError = errorMessage.isNotEmpty(),
            singleLine = true
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (usuario.isBlank() || pass.isBlank()) {
                    errorMessage = "Por favor ingrese usuario y contraseña"
                } else {
                    onNextScreen(usuario, pass)
                }
            }
        ) {
            Text("Enviar Datos")
        }
    }
}