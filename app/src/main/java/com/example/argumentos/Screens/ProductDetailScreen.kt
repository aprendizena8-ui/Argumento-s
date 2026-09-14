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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.argumentos.Models.Producto
import com.example.argumentos.R

@Composable
fun ProductDetailScreen(
    product: Producto,
    onAddToCart: (Producto) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Detalle",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Muestra la imagen del producto
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .size(200.dp)
                .padding(8.dp)
        )

        Text(
            text = product.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        Text(
            text = "$${product.price}",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.Start)
        )

        HorizontalDivider()

        Text(
            text = product.description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { onAddToCart(product) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Añadir al Carrito")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetail() {
    val producto = Producto(
        id = 1,
        name = "Monitor 4K",
        price = 350.0,
        description = "Monitor de 27 pulgadas con resolución 4K.",
        imageRes = R.drawable.productocarrito
    )
    ProductDetailScreen(product = producto, onAddToCart = {})
}