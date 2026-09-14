package com.example.argumentos.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.argumentos.R

@Composable
fun CapturarDatos(
    user: String,
    pass: String,
    onExploreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Imagen central decorativa de la app
        Image(
            painter = painterResource(id = R.drawable.productocarrito),
            contentDescription = "Logo Carrito",
            modifier = Modifier
                .size(150.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sesión Iniciada",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Usuario: $user",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Contraseña: $pass",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onExploreClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Explorar la Tienda")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCapturarDatos() {
    CapturarDatos(
        user = "hbj",
        pass = "...",
        onExploreClick = {}
    )
}