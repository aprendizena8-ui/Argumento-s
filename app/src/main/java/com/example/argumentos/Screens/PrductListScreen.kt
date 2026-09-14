package com.example.argumentos.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

// Lista de productos de ejemplo corregida con el recurso R.drawable.productocarrito
val SampleProducts = listOf(
    Producto(1, "Laptop", 2500000.0, "Computador portátil de alto rendimiento.", R.drawable.productocarrito),
    Producto(2, "Mouse", 80000.0, "Mouse inalámbrico ergonómico.", R.drawable.productocarrito),
    Producto(3, "Teclado", 50000.0, "Teclado mecánico RGB.", R.drawable.productocarrito),
    Producto(4, "Auriculares Bluetooth", 59.99, "Cancelación de ruido activa.", R.drawable.productocarrito),
    Producto(5, "Smartwatch Pro", 129.99, "GPS y monitor de salud.", R.drawable.productocarrito),
    Producto(6, "Monitor 4K", 350.0, "Monitor de 27 pulgadas con resolución 4K.", R.drawable.productocarrito),
    Producto(7, "Silla Ergonómica", 120.0, "Silla ajustable con soporte lumbar.", R.drawable.productocarrito)
)

@Composable
fun ProductListScreen(
    onProductClick: (Producto) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Mi Tienda",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(SampleProducts) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onProductClick(product) },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = product.imageRes),
                            contentDescription = product.name,
                            modifier = Modifier.size(50.dp)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$${product.price}",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Ver →",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewList() {
    ProductListScreen(onProductClick = {})
}